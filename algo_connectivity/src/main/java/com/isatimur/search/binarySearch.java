package com.isatimur.search;

/**
 * Created by abyakimenko on 10.11.2016.
 */
public class binarySearch {

    public static int executeSearch(int[] array, int key) {

        if (array == null || array.length == 0) return -1;

        int lowCorner = 0;
        int highCorner = array.length - 1;
        // делаем поиск до тех пор, пока выполняется условие
        while (lowCorner <= highCorner) {

            int middle = lowCorner + (highCorner - lowCorner) / 2;// середина рассматриваемого диапазона

            // определяем следующий индекс по условиям
            if (key < array[middle]) {
                highCorner = middle - 1;
            } else if (key > array[middle]) {
                lowCorner = middle + 1;
            } else return middle;
        }

        return -1;
    }
}
