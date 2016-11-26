package com.learning.princeton.algo.quicksort;

import edu.princeton.cs.algs4.StdRandom;

import static com.learning.princeton.algo.helpers.Helpers.exch;

/**
 * Created by abyakimenko on 24.11.2016.
 *
 * Use this kind if have duplicate keys
 */
public class QuickSortThreeWay {

    public static void sort(Comparable[] array) {

        StdRandom.shuffle(array);
        sort(array, 0, array.length - 1);
    }

    /**
     * @param array
     * @param lo
     * @param hi
     * @return
     */
    private static void sort(Comparable[] array, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = array[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = array[i].compareTo(v);
            if (cmp < 0) exch(array, lt++, i++);
            else if (cmp > 0) exch(array, i, gt--);
            else i++;
        }
        sort(array, lo, lt - 1);
        sort(array, gt + 1, hi);
    }
}
