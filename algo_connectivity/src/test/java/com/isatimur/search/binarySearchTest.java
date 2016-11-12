package com.isatimur.search;

import junit.framework.TestCase;

/**
 * Created by abyakimenko on 10.11.2016.
 */
public class binarySearchTest extends TestCase {

    private final int[] arrayOfInt = new int[]{1, 2, 3, 4, 8, 11, 14, 18, 20, 22, 26, 29, 35, 43, 48, 57, 65};

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testExecuteSearch() throws Exception {

        assertEquals(15, binarySearch.executeSearch(arrayOfInt, 57));
        assertEquals(16, binarySearch.executeSearch(arrayOfInt, 65));
        assertEquals(-1, binarySearch.executeSearch(arrayOfInt, 23));
        assertEquals(-1, binarySearch.executeSearch(arrayOfInt, 101));
    }

}