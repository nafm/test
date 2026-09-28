package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MainTest {

    @Test
    public void testMain() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }

    @Test
    public void testF() {
        assertDoesNotThrow(Main::f);
    }

    @Test
    public void testB() {
        assertDoesNotThrow(Main::b);
    }

    @Test
    public void testC() {
        assertDoesNotThrow(Main::c);
    }
}
