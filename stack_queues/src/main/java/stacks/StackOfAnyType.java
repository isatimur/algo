package stacks;

import java.util.Stack;

/**
 * Created by isati on 12.11.2016.
 */
public class StackOfAnyType<T> {
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

    private class Node<T> {
        T item;
        Node<T> next;
    }
}
