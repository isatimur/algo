package com.learning.princeton.algo.mergesort;

import static com.learning.princeton.algo.helpers.Helpers.less;

/**
 * Created by abyakimenko on 20.11.2016.
 *
 * Simple and non-recursive version of mergesort
 * but about 10% slower than recursive,
 * top-down mergesort on typical systems
 */
public class MergeBottomUp {

    public static void sort(Comparable[] unsortedArray) {

        int N = unsortedArray.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(unsortedArray, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        int i = lo,
                j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) aux[k] = a[j++];
            else if (j > hi) aux[k] = a[i++];
            else if (less(a[j], a[i])) aux[k] = a[j++];
            else aux[k] = a[i++];
        }
    }
}
