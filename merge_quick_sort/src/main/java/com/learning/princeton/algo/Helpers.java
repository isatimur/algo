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
}
