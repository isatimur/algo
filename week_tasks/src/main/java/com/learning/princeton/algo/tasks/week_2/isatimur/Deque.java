package com.learning.princeton.algo.tasks.week_2.isatimur;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by isati on 13.11.2016.
 * Dequeue. A double-ended queue or deque (pronounced "deck") is a generalization of a stack and a queue that supports
 * adding and removing items from either the front or the back of the data structure.
 * Create a generic data type Deque that implements the following API.
 * <p>
 * Corner cases. Throw a java.lang.NullPointerException if the client attempts to add a null item;
 * throw a java.util.NoSuchElementException if the client attempts to remove an item from an empty deque;
 * throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator;
 * throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return.
 * <p>
 * Performance requirements.   Your deque implementation must support each deque operation in constant worst-case time.
 * A deque containing n items must use at most 48n + 192 bytes of memory. and use space proportional
 * to the number of items currently in the deque. Additionally, your iterator implementation must support each operation (including construction) in constant worst-case time.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int length;

    public Deque() {
        first = null;
        last = null;
        length = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // return the number of items on the deque
    public int size() {
        return length;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new java.lang.NullPointerException();
        if (isEmpty()) {
            first = new Node(item);
            last = first;
        } else {
            Node newNode = new Node(item);
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }

        length++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) throw new java.lang.NullPointerException();

        if (isEmpty()) {
            last = new Node(item);
            first = last;
        } else {
            Node newNode = new Node(item);
            last.next = newNode;
            newNode.prev = last;
            newNode.next = null;
            last = newNode;
        }
        length++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Node oldNode = first;
        if (size() == 1) {
            this.first = null;
            this.last = null;
        } else {
            first.next.prev = null;
            first = first.next;
        }

        --length;
        oldNode.next = null;
        return oldNode.item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty()) throw new java.util.NoSuchElementException();

        Node oldNode = last;

        if (size() == 1) {
            this.first = null;
            this.last = null;
        } else {
            last.prev.next = null;
            last = last.prev;
        }
        oldNode.next = null;
        --length;
        return oldNode.item;
    }

    // return an iterator over items in order from front to end
    @Override
    public Iterator<Item> iterator() {
        return new Dequerator();
    }


    private class Node {
        private Item item;
        private Node next;
        private Node prev;

        Node(Item item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    private class Dequerator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                Item value = current.item;
                current = current.next;
                return value;
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
