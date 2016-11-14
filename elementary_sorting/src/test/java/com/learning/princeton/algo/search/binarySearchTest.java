package com.learning.princeton.algo.search;

import com.learning.princeton.algo.search.binarySearch;
import junit.framework.TestCase;

/**
 * Created by abyakimenko on 10.11.2016.
 * need a sorted array
 * algorithm complexity is (1 + lgN)
 */
public class binarySearchTest extends TestCase {

    private final int[] arrayOfInt = new int[]{1, 2, 3, 4, 8, 11, 14, 14, 18, 20, 22, 26, 29, 35, 43, 48, 57, 65};

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testExecuteSearch() throws Exception {

        assertEquals(16, binarySearch.executeSearch(arrayOfInt, 57));
        assertEquals(17, binarySearch.executeSearch(arrayOfInt, 65));
        assertEquals(6, binarySearch.executeSearch(arrayOfInt, 14));
        assertEquals(-1, binarySearch.executeSearch(arrayOfInt, 23));
        assertEquals(-1, binarySearch.executeSearch(arrayOfInt, 101));
    }

}