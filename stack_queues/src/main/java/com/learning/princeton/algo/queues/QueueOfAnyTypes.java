package com.learning.princeton.algo.queues;

/**
 * Created by isati on 13.11.2016.
 */
public class QueueOfAnyTypes<T> {


    private Node<T> first, last = null;

    public void enqueue(T item) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }

    }

    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private class Node<T> {
        T item;
        Node<T> next;
    }
}
