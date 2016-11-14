package com.learning.princeton.algo.sort;

/**
 * Created by abyakimenko on 13.11.2016.
 */
public class insertionSort {

    public static void executeSorting(int[] array) {

        if (array == null) {
            throw new RuntimeException("Can't sort null array. Array is null!!!");
        }

        for (int i = 1; i < array.length; ++i) {

            if (array[i] < array[i - 1]) {
                // swapping  all to the left
                insertion(array, i);
                for (int l = i - 1; l > 0; l--) {

                    if (array[l] < array[l - 1]) {
                        insertion(array, l);
                    }
                }
            }
        }
    }

    private static void insertion(int[] array, int i) {
        int currVal = array[i];
        array[i] = array[i - 1];
        array[i - 1] = currVal;
    }
}
