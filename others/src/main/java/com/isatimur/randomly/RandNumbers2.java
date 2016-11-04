package com.isatimur.randomly;

import java.util.Random;

/**
 * Created by Isachenko Timur on 18.10.2016.
 */
public class RandNumbers2 {
    private static Random random = new Random();

    public static void main(String[] args) {
        int N = 100;
        int[] elems = new int[N];
        for (int i = 0; i < N; i++) {
            elems[i] = i;
        }

        int index = N - 1;
        for (int i = N - 1; i >= 0; i--) {
            index = random.nextInt(i + 1);
            int temp = elems[index];
            elems[index] = elems[i];
            elems[i] = temp;
        }

        for (int i : elems) {
            System.out.println(i);
        }
    }

}
