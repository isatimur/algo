package com.isatimur.package_1_3;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Isachenko Timur on 11.10.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        int[] arrayOfAMax = new int[n];
        int[] arrayOfBMax = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }


        if (n > 0 && n <= 100000) {

            int maxA = a[0];
            int maxB = b[0];
            int maxSum = maxA + maxB;
            int Iindex = 0;
            int Jindex = 0;
            int currentIndex = 0;

            for (int i = 0; i < n; i++) {
                if (maxA < a[i]) {
                    maxA = a[i];
                    currentIndex = i;
                }
                arrayOfAMax[i] = currentIndex;
            }

            currentIndex = n - 1;
            maxB = b[n - 1];
            for (int i = (n - 1); i >= 0; i--) {
                if (b[i] >= maxB) {
                    maxB = b[i];
                    currentIndex = i;
                }
                arrayOfBMax[i] = currentIndex;
            }

            maxSum = a[arrayOfAMax[0]] + b[arrayOfBMax[0]];
            Iindex = arrayOfAMax[0];
            Jindex = arrayOfBMax[0];

            for (int i = 0; i < n; i++) {

                if (a[arrayOfAMax[i]] + b[arrayOfBMax[i]] > maxSum) {
                    maxSum = a[arrayOfAMax[i]] + b[arrayOfBMax[i]];
                    Iindex = arrayOfAMax[i];
                    Jindex = arrayOfBMax[i];
                }
            }
            System.out.println(Iindex + " " + Jindex);
        }
    }
}