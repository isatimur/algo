package com.learning.princeton.algo.sort;

import junit.framework.TestCase;

/**
 * Created by abyakimenko on 14.11.2016.
 */
public class insertionSortTest extends TestCase {

    private int[] arrayOfInts;
//    private final int[] arrayOfInts = new int[]{11, 21, 3, 41, 8, 2};


    @Override
    protected void setUp() throws Exception {
        arrayOfInts = new int[]{11, 21, 3, 41, 8, 11, 14, 14, 18, 20, 22, 26, 29, 35, 43, 48, 57, 65, 1, 2};
    }

    public void testExecuteSorting() throws Exception {

        insertionSort.executeSorting(arrayOfInts);

        assertEquals(arrayOfInts[0], 1);
        assertEquals(arrayOfInts[1], 2);
        assertEquals(arrayOfInts[3], 8);
    }

    public void testShellExecuteSorting() throws Exception {

        Comparable[] array = new Comparable[]{22, 11, 44, 57, 54, 57, 62, 42, 21, 11};
        shellSort.executeSorting(array);

        assertEquals(array[0], 11);
        assertEquals(array[1], 11);
        assertEquals(array[3], 22);
    }

}