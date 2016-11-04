package com.isatimur.randomly;

import java.util.Random;

/**
 * Created by Isachenko Timur on 18.10.2016.
 */
public class RandNumbers {
    private static Random random = new Random();

    public static void main(String[] args) {
        int[] counts = new int[]{0, 0, 0};
        int N = 10000000;
        for (int i = 0; i < N; i++) {
            int digit = getDigest();
            counts[digit]++;
        }
        for (int i : counts) {
            System.out.println((double) i / N);
        }
    }

    private static int getDigest() {
        int x1;
        int x2;
        do {
            x1 = random.nextInt(2);
            x2 = random.nextInt(2);
        } while (x1 == 1 && x2 == 0);
        return x1 + x2;

    }
}
