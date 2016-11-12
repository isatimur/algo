package stacks;

/**
 * Created by isati on 12.11.2016.
 */
public class ResizingArrayStackOfAnyType<T> {
    private T[] stack;
    private int N;

    public ResizingArrayStackOfAnyType() {
        stack = (T[]) new Object[1];
    }

    public void push(T item) {
        if (N == stack.length) {
            resizeArray(2 * stack.length);
        }
        stack[N++] = item;
    }

    public T pop() {
        T item = stack[--N];
        stack[N] = null;
        if (N > 0 && N == stack.length / 4) resizeArray(stack.length / 2);
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }


    private void resizeArray(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = stack[i];
        }
        stack = copy;
    }
}

