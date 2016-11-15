package com.learning.princeton.algo.tasks.week_2.abyakimenko.entities;

import junit.framework.TestCase;

import java.util.Iterator;

/**
 * Created by abyakimenko on 16.11.2016.
 */
public class DequeTest extends TestCase {

    Deque<Integer> deque = new Deque();

    public void setUp() throws Exception {
        deque = new Deque();
    }

    public void testAll() throws Exception {

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        assertEquals(deque.removeFirst().intValue(), 3);

        deque.addLast(5);
        deque.addLast(4);
        deque.addLast(1);

        assertEquals(deque.removeLast().intValue(), 1);
        assertEquals(deque.isEmpty(), false);
        assertEquals(deque.size(), 4);

        Iterator<Integer> iterator = deque.iterator();
        assertEquals(iterator.next().intValue(), 2);
        assertEquals(iterator.hasNext(), true);

        iterator.next();
        iterator.next();
        assertEquals(iterator.hasNext(), false);

        deque.removeLast();
        deque.removeLast();
        deque.removeFirst();
        deque.removeFirst();
        assertEquals(deque.isEmpty(), true);
    }

    public void testIterator() throws Exception {

    }

}