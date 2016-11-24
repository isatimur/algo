package com.learning.princeton.algo.select;

import com.learning.princeton.algo.quicksort.QuickSort;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by abyakimenko on 24.11.2016.
 */
public class QuickSelect {

    public static Comparable select(Comparable[] array, int k) {

        StdRandom.shuffle(array);
        int l0 = 0;
        int hi = array.length - 1;

        while (hi > l0) {

            int j = QuickSort.getSupportPoint(array, l0, hi);
            if (j < k) {
                l0 = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                return array[k];
            }
        }

        return array[k];
    }
}
