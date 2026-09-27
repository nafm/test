package com.nafm.tui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    @DisplayName("Doit trier correctement un tableau desordonne")
    void testBubbleSortUnsorted() {
        int[] input = {64, 34, 25, 12, 22, 11, 90, 8};
        int[] expected = {8, 11, 12, 22, 25, 34, 64, 90};
        assertArrayEquals(expected, BubbleSort.sort(input));
    }

    @Test
    @DisplayName("Doit gerer un tableau deja trie")
    void testBubbleSortAlreadySorted() {
        int[] input = {1, 2, 3, 4, 5};
        assertArrayEquals(input, BubbleSort.sort(input));
    }

    @Test
    @DisplayName("Doit gerer un tableau inverse")
    void testBubbleSortReversed() {
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, BubbleSort.sort(input));
    }

    @Test
    @DisplayName("Doit gerer les tableaux vides ou a un seul element")
    void testBubbleSortEdgeCases() {
        assertArrayEquals(new int[0], BubbleSort.sort(new int[0]));
        assertArrayEquals(new int[]{42}, BubbleSort.sort(new int[]{42}));
    }

    @Test
    @DisplayName("Doit gerer un tableau avec des doublons")
    void testBubbleSortWithDuplicates() {
        int[] input = {3, 1, 2, 3, 1};
        int[] expected = {1, 1, 2, 3, 3};
        assertArrayEquals(expected, BubbleSort.sort(input));
    }
}