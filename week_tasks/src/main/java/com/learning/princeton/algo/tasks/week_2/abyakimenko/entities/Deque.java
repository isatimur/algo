package com.learning.princeton.algo.tasks.week_2.abyakimenko.entities;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Write a generic data type for a deque and a randomized queue. The goal of this assignment is to implement elementary
 * data structures using arrays and linked lists, and to introduce you to generics and iterators.
 * <p>
 * Dequeue. A double-ended queue or deque (pronounced "deck") is a generalization of a stack and a queue that supports
 * adding and removing items from either the front or the back of the data structure. Create a generic data type Deque that implements the following API:
 * <p>
 * <p>
 * Corner cases.
 * - throw a java.lang.NullPointerException if the client attempts to add a null item;
 * - throw a java.util.NoSuchElementException if the client attempts to remove an item from an empty deque;
 * - throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator;
 * - throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return.
 * <p>
 * Performance requirements.   Your deque implementation must support each deque operation in constant worst-case time.
 * A deque containing n items must use at most 48n + 192 bytes of memory. and use space proportional to the number of
 * items currently in the deque. Additionally, your iterator implementation must support each operation
 * (including construction) in constant worst-case time.
 *
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {

    private int size;
    private Nod first;
    private Nod last;

    /**
     * construct an empty deque
     */
    public Deque() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    /**
     * is the deque empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * return the number of items on the deque
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * add the item to the front
     *
     * @param item
     */
    public void addFirst(Item item) {

        checkIfNull(item);

        if (isEmpty()) {
            first = new Nod(item);
            last = first;
        } else {
            final Nod nod = new Nod(item);
            nod.next = first;
            nod.prev = null;
            first.prev = nod;
            first = nod;
        }

        size++;
    }

    /**
     * add the item to the end
     *
     * @param item
     */
    public void addLast(Item item) {

        checkIfNull(item);

        if (isEmpty()) {
            first = new Nod(item);
            last = first;
        } else {
            final Nod nod = new Nod(item);
            nod.prev = last;
            nod.next = null;
            last.next = nod;
            last = nod;
        }

        size++;
    }

    /**
     * remove and return the item from the front
     *
     * @return
     */
    public Item removeFirst() {

        checkEmptyQueue();

        final Nod oldNod = first;
        if (size() == 1) {
            first = last = null;
        } else {
            first.next.prev = null;
            first = first.next;
        }

        size--;
        oldNod.next = null;
        return oldNod.item;
    }

    /**
     * remove and return the item from the end
     *
     * @return Item
     */
    public Item removeLast() {

        checkEmptyQueue();

        final Nod oldLastNod = last;
        if (size() == 1) {
            last = first = null;
        } else {
            last.prev.next = null;
            last = last.prev;
        }

        size--;
        oldLastNod.prev = null;
        return oldLastNod.item;
    }

    /**
     * return an iterator over items in order from front to end
     *
     * @return Iterator
     */
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }


    /*** Helpers ***/
    private void checkIfNull(Item item) {
        if (item == null) {
            throw new NullPointerException("Attemp to add null item.");
        }
    }

    private void checkEmptyQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Attemp to remove item form empty queue.");
        }
    }

    /**
     * describe inner queue data
     */
    private class Nod {

        private Item item;
        private Nod next;
        private Nod prev;

        public Nod(Item item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    private class DequeIterator implements Iterator<Item> {

        private Nod currentNod = first;

        @Override
        public boolean hasNext() {
            return currentNod != null && currentNod.next != null;
        }

        @Override
        public Item next() {

            if (hasNext()) {
                Item elem = currentNod.item;
                currentNod = currentNod.next;
                return elem;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}