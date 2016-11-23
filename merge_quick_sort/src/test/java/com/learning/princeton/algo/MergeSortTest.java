package com.learning.princeton.algo;

import com.learning.princeton.algo.mergesort.MergeBottomUp;
import com.learning.princeton.algo.mergesort.MergeSort;
import com.learning.princeton.algo.mergesort.MergeSortV1;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

/**
 * Created by abyakimenko on 20.11.2016.
 */
public class MergeSortTest {

    private int[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;

    private Integer[] unsortedArray;

    @Before
    public void setUp() throws Exception {

        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }

//        unsortedArray = new Integer[]{2, 5, 7, 8, 9, 12, 3, 1, 2, 22, 45, 67, 11, 77, 89, 15, 95};
        unsortedArray = new Integer[]{9, 38, 27, 43, 3, 9, 82, 10};
    }

    @Test
    public void sort() throws Exception {

        int[] primArray = new int[]{-15, 9, -5, 38, 27, 43, 3, 9, 82, 10};
        new MergeSortV1().sort(primArray);

        MergeSort.sort(unsortedArray);

//        assertEquals(unsortedArray[0], new Integer(1));
//        assertEquals(unsortedArray[unsortedArray.length - 1], new Integer(95));
    }

    @Test
    public void testMergeBottomUp() {

        long startTime = System.currentTimeMillis();
        MergeBottomUp.sort(unsortedArray);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("MergeBottomUp:" + elapsedTime);
    }

    @Test
    public void testMergeSort() {

        long startTime = System.currentTimeMillis();

        new MergeSortV1().sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Mergesort " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Should not happen");
            }
        }

        assertTrue(true);
    }

    @Test
    public void itWorksRepeatably() {
        for (int i = 0; i < 200; i++) {
            numbers = new int[SIZE];
            Random generator = new Random();
            for (int a = 0; a < numbers.length; a++) {
                numbers[a] = generator.nextInt(MAX);
            }
//            Mergesort sorter = new Mergesort();
//            sorter.sort(numbers);
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    fail("Should not happen");
                }
            }
            assertTrue(true);
        }
    }

    @Test
    public void testStandardSort() {
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Should not happen");
            }
        }
        assertTrue(true);
    }

}