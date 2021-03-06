package com.learning.princeton.algo.quicksort;

import org.junit.Test;

import static com.learning.princeton.algo.BaseResources.unsorted;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by abyakimenko on 24.11.2016.
 */
public class QuickSortTest {

    @Test
    public void sort() throws Exception {

        QuickSort.sort(unsorted);
        assertTrue(unsorted[0] == 1);
        assertEquals(unsorted[unsorted.length - 1].intValue(), 88);
    }
}