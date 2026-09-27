package com.nafm.tui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Gestionnaire d affichage TUI base sur les sequences d echappement ANSI standard.
 */
public class TerminalUI {

    // Sequences ANSI standard
    public static final String CLEAR_SCREEN = "\033[H\033[2J";
    public static final String RESET = "\033[0m";
    public static final String BOLD = "\033[1m";
    
    // Couleurs
    public static final String COLOR_CYAN = "\033[36m";
    public static final String COLOR_GREEN = "\033[32m";
    public static final String COLOR_YELLOW = "\033[33m";
    public static final String COLOR_RED = "\033[31m";
    public static final String COLOR_GRAY = "\033[90m";

    private final PrintStream out;
    private final Scanner scanner;

    public TerminalUI(InputStream in, PrintStream out) {
        this.out = out;
        this.scanner = new Scanner(in);
    }

    public void clear() {
        out.print(CLEAR_SCREEN);
        out.flush();
    }

    public void renderHeader(String title) {
        out.println(COLOR_CYAN + BOLD + "==================================================" + RESET);
        out.printf(COLOR_CYAN + BOLD + "   %-46s %n" + RESET, title);
        out.println(COLOR_CYAN + BOLD + "==================================================" + RESET);
    }

    public void renderMenu() {
        out.println();
        out.println(COLOR_YELLOW + "  [1]" + RESET + " Afficher le statut systeme (Java 21)");
        out.println(COLOR_YELLOW + "  [2]" + RESET + " Executer un tri a bulle (Bubble Sort)");
        out.println(COLOR_YELLOW + "  [h]" + RESET + " Aide");
        out.println(COLOR_RED    + "  [q]" + RESET + " Quitter");
        out.println();
    }

    public String promptInput() {
        out.print(COLOR_GREEN + "tui-app> " + RESET);
        out.flush();
        if (scanner.hasNextLine()) {
            return scanner.nextLine().trim();
        }
        return "q";
    }

    public void printInfo(String message) {
        out.println(COLOR_CYAN + "[INFO] " + RESET + message);
    }

    public void printSuccess(String message) {
        out.println(COLOR_GREEN + "[SUCCES] " + RESET + message);
    }

    public void printWarning(String message) {
        out.println(COLOR_YELLOW + "[ATTENTION] " + RESET + message);
    }
}
