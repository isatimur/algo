package com.learning.princeton.algo;

/**
 * Created by abyakimenko on 20.11.2016.
 */
public class Helpers {

    private Helpers() {
    }

    // is first < second ?
    public static boolean less(Comparable first, Comparable second) {
        return first.compareTo(second) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
