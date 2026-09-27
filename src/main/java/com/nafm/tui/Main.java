package com.nafm.tui;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Point d entree de l application TUI.
 */
public class Main {

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
                        ui.printInfo("Veuillez saisir une liste de nombres entiers separes par des virgules (ex: 5,1,9,3) :");
                        
                        String input = ui.promptInput();
                        if (input != null && !input.isBlank()) {
                            try {
                                String[] parts = input.split(",");
                                int[] numbers = new int[parts.length];
                                for (int i = 0; i < parts.length; i++) {
                                    numbers[i] = Integer.parseInt(parts[i].trim());
                                }
                                
                                ui.printInfo("Tableau initial : " + Arrays.toString(numbers));
                                
                                long start = System.nanoTime();
                                int[] sorted = BubbleSort.sort(numbers);
                                long duration = System.nanoTime() - start;
                                
                                ui.printSuccess("Tableau trie     : " + Arrays.toString(sorted));
                                ui.printInfo(String.format("Temps de calcul : %.3f ms", duration / 1_000_000.0));
                            } catch (NumberFormatException e) {
                                ui.printWarning("Erreur : Veuillez entrer uniquement des nombres entiers valides.");
                            }
                        }
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