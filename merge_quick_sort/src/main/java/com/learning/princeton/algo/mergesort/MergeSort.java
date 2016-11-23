package com.learning.princeton.algo.mergesort;

import com.learning.princeton.algo.helpers.Helpers;

/**
 * Created by abyakimenko on 20.11.2016.
 */
public class MergeSort {

    private static Integer[] auxiliary;

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void merge(Comparable[] first, Comparable[] second, Comparable[] result) {

        //Index Position in first array - starting with first element
        int iFirst = 0;

        //Index Position in second array - starting with first element
        int iSecond = 0;

        //Index Position in merged array - starting with first position
        int iMerged = 0;

        //Compare elements at iFirst and iSecond, and move smaller element at iMerged
        while (iFirst < first.length && iSecond < second.length) {
            if (Helpers.less(first[iFirst], second[iSecond])) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        //copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }

    // new Integer[]{38, 27, 43, 3, 9, 82, 10};
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] unsortedArray) {

        if (unsortedArray.length <= 1) {
            return;
        }

        // Делим изначальный массив на 2 части и копируем в 2 вспомогательных
        Comparable[] first = new Comparable[unsortedArray.length / 2];
        Comparable[] second = new Comparable[unsortedArray.length - first.length];
        System.arraycopy(unsortedArray, 0, first, 0, first.length);
        System.arraycopy(unsortedArray, first.length, second, 0, second.length);

        // Рекурсивно сотируем каждую часть
        sort(first);
        sort(second);

        // Мержим обе части, перезаписывая изначальный массив
        merge(first, second, unsortedArray);
    }
}
