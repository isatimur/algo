package com.learning.princeton.algo.stacks;

import java.util.Iterator;

/**
 * Created by isati on 12.11.2016.
 */
public class StackIterable<T> implements Iterable<T> {
    private Node<T> first = null;

    public void push(T value) {
        Node<T> oldFirst = first;
        first = new Node<>();
        first.item = value;
        first.next = oldFirst;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>();
    }

    private class Node<T> {
        T item;
        Node next;
    }

    private class ListIterator<T> implements Iterator<T> {

        private Node<T> current = (Node<T>) first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("does not support in stack");
        }
    }
}
