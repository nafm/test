package com.nafm.tui;

/**
 * Point d entree de l application TUI.
 */
public class Main {

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
                    ui.printSuccess("Action de test executee avec succes.");
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
