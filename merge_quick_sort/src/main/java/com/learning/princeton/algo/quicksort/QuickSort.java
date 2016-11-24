package com.learning.princeton.algo.quicksort;

import edu.princeton.cs.algs4.StdRandom;

import static com.learning.princeton.algo.helpers.Helpers.exch;
import static com.learning.princeton.algo.helpers.Helpers.less;

/**
 * Created by abyakimenko on 24.11.2016.
 */
public class QuickSort {


    public static void sort(Comparable[] array) {

        StdRandom.shuffle(array);
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int l0, int hi) {

        if (hi <= l0) {
            return;
        }
        int j = getSupportPoint(array, l0, hi);
        sort(array, l0, j - 1);
        sort(array, j + 1, hi);
    }

    /**
     * define support point
     * @param array
     * @param l0
     * @param hi
     * @return
     */
    public static int getSupportPoint(Comparable[] array, int l0, int hi) {

        int i = l0;
        int j = hi + 1;

        while (true) {

            // find item on the left part to swap
            while (less(array[++i], array[l0])) {
                if (i == hi) {
                    break;
                }
            }

            // find item on the right part to swap
            while (less(array[l0], array[--j])) {
                if (l0 == j) {
                    break;
                }
            }

            // check if pointers cross
            if (i >= j) {
                break;
            }

            // swap
            exch(array, i, j);
        }

        // swap with partitioning item
        exch(array, l0, j);

        // index of item now known to be placed
        return j;
    }
}
