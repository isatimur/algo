package elementary.sort;

import java.util.Arrays;

/**
 * Created by abyakimenko on 13.11.2016.
 */
public class selectionSort {

    public static void executeSorting(int[] arrayOfInts) {

        if (arrayOfInts == null) {
            throw new RuntimeException("Can't sort null array. Array is null!!!");
        }

        for (int i = 0; i < arrayOfInts.length; ++i) {

            int[] tmpArray = Arrays.copyOfRange(arrayOfInts, i, arrayOfInts.length);

            int minIndex = findMinIndex(tmpArray),
                    tmpVal = arrayOfInts[i];

            // swapping
            arrayOfInts[i] = arrayOfInts[minIndex + i];
            arrayOfInts[minIndex + i] = tmpVal;
        }
    }

    private static int findMinIndex(int[] array) {

        int minIndex = 0,
                minValue = array[minIndex];

        for (int i = 1; i < array.length; ++i) {

            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
