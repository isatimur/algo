package com.learning.princeton.algo.tasks.week_2.abyakimenko.entities;

import java.util.*;


public class RandomizedQueueList<Item> implements Iterable<Item> {

    private List<Item> queue;

    private int count = 0;

    public RandomizedQueueList() {          // construct an empty randomized queue
        queue = new ArrayList<>();
        count = 0;
    }

    public boolean isEmpty() {          // is the queue empty?
        return count == 0;
    }

    public int size() {                 // return the number of items on the queue
        return count;
    }

    public void enqueue(Item item) {    // add the item
        if (item == null) {
            throw new NullPointerException();
        }
        queue.add(item);
        queue.set(count, item);
        count++;
    }

    public Item dequeue() {             // delete and return a random item
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int pt = new Random().nextInt();
        Item current = queue.get(pt);
        queue.set(pt, queue.get(count - 1));
        count--;
        queue.remove(count);
        return current;
    }

    public Item sample() {               // return (but do not delete) a random item
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int pt = new Random().nextInt();
        return queue.get(pt);
    }

    @Override
    public Iterator<Item> iterator() {   // return an independent iterator over items in random order
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        List<Item> rQ = null;

        int pt;

        public RandomizedQueueIterator() {
            rQ = new ArrayList<>();
            for (int i = 0; i < count; i++)
                rQ.add(queue.get(i));
            Collections.shuffle(rQ);
            pt = 0;
        }

        @Override
        public boolean hasNext() {
            return pt < count;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            Item current = rQ.get(pt);
            pt++;
            return current;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
}