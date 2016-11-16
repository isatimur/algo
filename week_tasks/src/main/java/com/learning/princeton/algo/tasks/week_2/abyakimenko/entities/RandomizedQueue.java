package com.learning.princeton.algo.tasks.week_2.abyakimenko.entities;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Randomized queue. A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly
 * at random from items in the data structure. Create a generic data type RandomizedQueue that implements the following API:
 * <p>
 * Corner cases. The order of two or more iterators to the same randomized queue must be mutually independent; each
 * iterator must maintain its own random order. Throw a java.lang.NullPointerException if the client attempts to add a
 * null item; throw a java.util.NoSuchElementException if the client attempts to sample or dequeue an item from an empty
 * randomized queue; throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator;
 * throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return.
 * <p>
 * Performance requirements. Your randomized queue implementation must support each randomized queue operation
 * (besides creating an iterator) in constant amortized time. That is, any sequence of m randomized queue operations
 * (starting from an empty queue) should take at most cm steps in the worst case, for some constant c. A randomized
 * queue containing n items must use at most 48n + 192 bytes of memory. Additionally, your iterator implementation must
 * support operations next() and hasNext() in constant worst-case time; and construction in linear time; you may
 * (and will need to) use a linear amount of extra memory per iterator.
 *
 * @param <Item>
 */

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size;
    private Item[] arryableQueue;

    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
        arryableQueue = (Item[]) new Object[2];
    }

    // is the queue empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // return the number of items on the queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {

        if (item == null) throw new NullPointerException();
        if (size() == arryableQueue.length) {
            resizeArray(arryableQueue.length * 2);
        }
        arryableQueue[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {

        if (isEmpty()) throw new java.util.NoSuchElementException();
        int randomIndex = uniform(size);
        Item item = arryableQueue[randomIndex];
        arryableQueue[randomIndex] = arryableQueue[size() - 1];
        arryableQueue[size() - 1] = null;

        size--;

        if (size() > 0 && size() == arryableQueue.length / 4) {
            resizeArray(size() / 2);
        }

        return item;
    }

    private void resizeArray(int value) {

        Item[] newarray = (Item[]) new Object[value];

        for (int i = 0; i < size; i++) {
            newarray[i] = arryableQueue[i];
        }
        arryableQueue = newarray;
    }

    private static int uniform(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("argument must be positive");
        } else {
            return new Random(n).nextInt(n);
        }
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int random = uniform(size);
        Item item = arryableQueue[random];
        return item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {

        private Item[] currentArray = null;
        private int length = 0;

        public RandomIterator() {
            currentArray = (Item[]) new Object[arryableQueue.length];
            for (int i = 0; i < arryableQueue.length; i++) {
                currentArray[i] = arryableQueue[i];
            }
            length = size;
        }

        @Override
        public boolean hasNext() {
            return length > 0;
        }

        @Override
        public Item next() {

            if (hasNext()) {

                int randomIndex = uniform(length);
                currentArray[randomIndex] = currentArray[length - 1];
                currentArray[length - 1] = null;
                length--;
                Item item = currentArray[randomIndex];
                return item;
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