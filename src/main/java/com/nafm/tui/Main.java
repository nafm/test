package com.nafm.tui;

import java.util.Arrays;

/**
 * Point d entree de l application TUI.
 */
public class Main {

    /**
     * Algorithme de tri fusion (Merge Sort).
     * @param arr Tableau d entiers a trier
     * @return Nouvelle copie du tableau trie par ordre croissant
     */
    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr == null ? new int[0] : arr.clone();
        }
        int[] result = arr.clone();
        sort(result, 0, result.length - 1);
        return result;
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void main(String[] args) {
        // Enregistrement du hook de fermeture pour le nettoyage des ressources terminales
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nNettoyage des ressources... Au revoir !");
        }));

        try {
            TerminalUI ui = new TerminalUI(System.in, System.out);
            boolean running = true;

            ui.clear();
            ui.renderHeader("Java 21 TUI Application - nafm/test");
            ui.printInfo("Demarrage du boilerplate en terminal standard...");

            while (running) {
                ui.renderMenu();
                String choice = ui.promptInput();

                if (choice == null) break;

                switch (choice.toLowerCase()) {
                    case "1" -> {
                        ui.clear();
                        ui.renderHeader("Informations Systeme");
                        ui.printSuccess("Version Java runtime : " + System.getProperty("java.version"));
                        ui.printInfo("OS : " + System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ")");
                        ui.printInfo("Memoire libre JVM : " + (Runtime.getRuntime().freeMemory() / (1024 * 1024)) + " Mo");
                    }
                    case "2" -> {
                        ui.clear();
                        ui.renderHeader("Tri a bulles optimise (Bubble Sort)");
                        int[] numbers = {64, 34, 25, 12, 22, 11, 90, 8};
                        ui.printInfo("Tableau initial : " + Arrays.toString(numbers));
                        
                        long start = System.nanoTime();
                        int[] sorted = BubbleSort.sort(numbers.clone());
                        long duration = System.nanoTime() - start;
                        
                        ui.printSuccess("Tableau trie     : " + Arrays.toString(sorted));
                        ui.printInfo(String.format("Temps de calcul : %.3f ms", duration / 1_000_000.0));
                    }
                    case "h", "help" -> {
                        ui.printInfo("Aide : Tapez le numero d une option ou q pour fermer le terminal.");
                    }
                    case "q", "quit", "exit" -> {
                        ui.printWarning("Arret de l application...");
                        running = false;
                    }
                    default -> {
                        ui.printWarning("Option non reconnue : " + choice + ". Tapez h pour l aide.");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Une erreur critique est survenue : " + e.getMessage());
            System.exit(1);
        }
    }
}