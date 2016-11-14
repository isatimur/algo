package com.learning.princeton.algo.sort;

import junit.framework.TestCase;

/**
 * Created by abyakimenko on 13.11.2016.
 * complexity is N2/2
 */
public class selectionSortTest extends TestCase {

    private final int[] arrayOfInts = new int[]{11, 21, 3, 41, 8, 11, 14, 14, 18, 20, 22, 26, 29, 35, 43, 48, 57, 65, 1, 2};

    public void testExecuteSorting() throws Exception {

        selectionSort.executeSorting(arrayOfInts);

        assertEquals(arrayOfInts[0], 1);
        assertEquals(arrayOfInts[1], 2);
        assertEquals(arrayOfInts[3], 8);
    }

}