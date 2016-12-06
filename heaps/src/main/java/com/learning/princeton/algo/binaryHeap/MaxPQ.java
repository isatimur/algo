package com.learning.princeton.algo.binaryHeap;

/**
 * Created by isati on 05.12.2016.
 */
public class MaxPQ<K extends Comparable<K>> {
    private K[] pq;
    private int n;

    private void resizeArray(int capacity) {
        K[] copy = (K[]) new Comparable[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = pq[i];
        }
        pq = copy;
    }

    public MaxPQ(int n) {
        pq = (K[]) new Comparable[n + 1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(K k) {
        if (n == pq.length) {
            resizeArray(2 * pq.length);
        }
        pq[++n] = k;
        swim(n);
    }

    public K delMax() {
        K k = pq[1];
        if (n > 0 && n == pq.length / 4) resizeArray(pq.length / 2);
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        return k;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i]!=null && pq[i].compareTo(pq[j]) < 0 ;
    }

    private void exch(int i, int j) {
        K t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

}
