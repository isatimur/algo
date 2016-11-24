package com.learning.princeton.algo.select;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by abyakimenko on 24.11.2016.
 */
public class QuickSelectTest {

    final Integer[] unsorted = {34, 1, 4, 3, 2, 55, 44, 33, 22, 5, 100, 9, 6, 88, 56, 43};

    @Test
    public void select() throws Exception {

        // find k smallest element
        Integer g1 = (Integer)QuickSelect.select(unsorted, 0);
        Integer g2 = (Integer)QuickSelect.select(unsorted, 1);
        Integer g3 = (Integer)QuickSelect.select(unsorted, 2);

        assertEquals(g1.intValue(),1);
        assertEquals(g2.intValue(),2);
        assertEquals(g3.intValue(),3);
    }
}