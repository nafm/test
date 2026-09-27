package com.nafm.tui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    @DisplayName("Doit trier correctement un tableau desordonne")
    void testMergeSortUnsorted() {
        int[] input = {64, 34, 25, 12, 22, 11, 90, 8};
        int[] expected = {8, 11, 12, 22, 25, 34, 64, 90};
        assertArrayEquals(expected, MergeSort.sort(input));
    }

    @Test
    @DisplayName("Doit gerer un tableau deja trie")
    void testMergeSortAlreadySorted() {
        int[] input = {1, 2, 3, 4, 5};
        assertArrayEquals(input, MergeSort.sort(input));
    }

    @Test
    @DisplayName("Doit gerer un tableau inverse")
    void testMergeSortReversed() {
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, MergeSort.sort(input));
    }

    @Test
    @DisplayName("Doit gerer les tableaux vides ou a un seul element")
    void testMergeSortEdgeCases() {
        assertArrayEquals(new int[0], MergeSort.sort(new int[0]));
        assertArrayEquals(new int[]{42}, MergeSort.sort(new int[]{42}));
    }

    @Test
    @DisplayName("Doit gerer un tableau avec des doublons")
    void testMergeSortWithDuplicates() {
        int[] input = {3, 1, 2, 3, 1};
        int[] expected = {1, 1, 2, 3, 3};
        assertArrayEquals(expected, MergeSort.sort(input));
    }
}