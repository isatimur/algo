package com.learning.princeton.algo.tasks.week_2.isatimur;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by isati on 15.11.2016.
 * <p>
 * Randomized queue. A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random from items in the data structure. Create a generic data type RandomizedQueue that implements the following API:
 * Corner cases.
 * The order of two or more iterators to the same randomized queue must be mutually independent;
 * each iterator must maintain its own random order.
 * Throw a java.lang.NullPointerException if the client attempts to add a null item; throw a java.util.NoSuchElementException if the client attempts to sample or dequeue an item from an empty randomized queue;
 * throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator;
 * throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return.
 * <p>
 * Performance requirements.
 * Your randomized queue implementation must support each randomized queue operation (besides creating an iterator) in constant amortized time.
 * That is, any sequence of m randomized queue operations (starting from an empty queue) should take at most cm steps in the worst case, for some constant c.
 * A randomized queue containing n items must use at most 48n + 192 bytes of memory.
 * Additionally, your iterator implementation must support operations next() and hasNext() in constant worst-case time;
 * and construction in linear time;
 * you may (and will need to) use a linear amount of extra memory per iterator.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] array = null;
    private int N;

    public RandomizedQueue() {
        array = (Item[]) new Object[2];
        N = 0;
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        for (Integer i : queue) {
            System.out.println(i);
        }
    }

    // is the queue empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the queue
    public int size() {
        return N;
    }

    private void resizeArray(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new java.lang.NullPointerException();
        if (N == array.length) {
            resizeArray(array.length * 2);
        }
        array[N++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        int random = StdRandom.uniform(N);
        Item item = array[random];
        array[random] = array[N - 1];
        array[N - 1] = null;
        N--;
        if (N > 0 && N == array.length / 4) resizeArray(array.length / 2);

        return item;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        int random = StdRandom.uniform(N);
        Item item = array[random];
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Randomator<>();
    }

    private class Randomator<Item> implements Iterator<Item> {

        private Item[] currentArray = null;
        private int iteratorsN = 0;

        public Randomator() {
            currentArray = (Item[]) new Object[array.length];
            for (int i = 0; i < array.length; i++) {
                currentArray[i] = (Item) array[i];
            }
            iteratorsN = N;
        }

        @Override
        public boolean hasNext() {
            return iteratorsN > 0;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                int random = StdRandom.uniform(iteratorsN);
                Item item = currentArray[random];
                currentArray[random] = currentArray[iteratorsN - 1];
                currentArray[iteratorsN - 1] = null;
                iteratorsN--;
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
