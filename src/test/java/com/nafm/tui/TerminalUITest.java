package com.nafm.tui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TerminalUITest {

    @Test
    @DisplayName("Verifie que la TUI affiche l en-tete et lit la saisie utilisateur")
    void testPromptAndHeader() {
        ByteArrayInputStream in = new ByteArrayInputStream("test\n".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        TerminalUI ui = new TerminalUI(in, new PrintStream(out));
        ui.renderHeader("Test Title");
        String input = ui.promptInput();

        assertEquals("test", input);
        String output = out.toString();
        assertTrue(output.contains("Test Title"));
    }
}
