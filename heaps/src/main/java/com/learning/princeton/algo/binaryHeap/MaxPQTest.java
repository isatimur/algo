package com.learning.princeton.algo.binaryHeap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by isati on 05.12.2016.
 */
public class MaxPQTest {
    private MaxPQ<String> maxPQ;

    @org.junit.Before
    public void setUp() throws Exception {
        maxPQ = new MaxPQ<>(10);
    }

    @Test
    public void testDelMax() {
        maxPQ.insert("O");
        maxPQ.insert("N");
        maxPQ.insert("S");
        assertEquals("S", maxPQ.delMax());
        maxPQ.insert("P");
        maxPQ.insert("C");
        maxPQ.insert("A");
        maxPQ.insert("E");
        maxPQ.insert("I");
        maxPQ.insert("H");
        maxPQ.insert("R");
        assertEquals("R", maxPQ.delMax());
        assertNotEquals("A", maxPQ.delMax());
    }
}