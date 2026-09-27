package com.nafm.tui;

import java.util.Arrays;

/**
 * Point d entree de l application TUI.
 */
public class Main {

    /**
     * Algorithme de tri a bulle (Bubble Sort) optimise avec indicateur d echange.
     * @param arr Tableau d entiers a trier
     * @return Nouvelle copie du tableau trie par ordre croissant
     */
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr == null ? new int[0] : arr.clone();
        }
        int[] result = arr.clone();
        int n = result.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (result[j] > result[j + 1]) {
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return result;
    }

    public static void main(String[] args) {
        TerminalUI ui = new TerminalUI(System.in, System.out);
        boolean running = true;

        ui.clear();
        ui.renderHeader("Java 21 TUI Application - nafm/test");
        ui.printInfo("Demarrage du boilerplate en terminal standard...");

        while (running) {
            ui.renderMenu();
            String choice = ui.promptInput();

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
                    ui.renderHeader("Tri a bulle (Bubble Sort)");
                    int[] numbers = {64, 34, 25, 12, 22, 11, 90, 8};
                    ui.printInfo("Tableau initial : " + Arrays.toString(numbers));
                    
                    long start = System.nanoTime();
                    int[] sorted = bubbleSort(numbers);
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

        System.out.println("\nAu revoir !");
    }
}
