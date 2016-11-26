package com.learning.princeton.algo.quicksort;

import org.junit.Test;

import static com.learning.princeton.algo.BaseResources.unsorted;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by abyakimenko on 26.11.2016.
 */
public class QuickSortThreeWayTest {
    @Test
    public void sort() throws Exception {

        QuickSortThreeWay.sort(unsorted);
        assertTrue(unsorted[0] == 1);
        assertEquals(unsorted[unsorted.length - 1].intValue(), 88);
    }

}