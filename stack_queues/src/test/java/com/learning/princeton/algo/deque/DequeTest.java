package com.learning.princeton.algo.deque;

import junit.framework.TestCase;

/**
 * Created by isati on 14.11.2016.
 */
public class DequeTest extends TestCase {

    public void testDeque() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(0);
        deque.addFirst(1);
        System.out.println(deque.removeLast());
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5);
        System.out.println(deque.removeLast());

    }
}