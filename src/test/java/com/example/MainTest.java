package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void testMain() {
        // Simple test to verify Main class exists and can be called
        Main.main(new String[]{});
        assertTrue(true);
    }
}
