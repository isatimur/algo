package com.learning.princeton.algo.helpers;

/**
 * Created by abyakimenko on 20.11.2016.
 */
public class Helpers {

    private Helpers() {
    }

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/
    // is first < second ?
    public static boolean less(Comparable first, Comparable second) {
        return first.compareTo(second) < 0;
    }

    // exchange a[i] and a[j]
    public static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    // is the array h-sorted?
    private static boolean isHsorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++)
            if (less(a[i], a[i - h])) return false;
        return true;
    }
}
