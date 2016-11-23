package com.learning.princeton.algo.quicksort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by abyakimenko on 24.11.2016.
 */
public class QuickSortTest {

    final Integer[] unsorted = {34, 1, 4, 3, 2, 55, 44, 33, 22, 5, 9, 6, 88, 56, 43};

    @Test
    public void sort() throws Exception {

        QuickSort.sort(unsorted);

        assertTrue(unsorted[0] == 1);
        assertEquals(unsorted[unsorted.length - 1].intValue(), 88);
    }

}