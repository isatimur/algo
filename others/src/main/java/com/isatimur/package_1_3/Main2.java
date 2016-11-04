package com.isatimur.package_1_3;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Isachenko Timur on 18.10.2016.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();

        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int ind = Arrays.binarySearch(a, b[i]);
            if (ind >= 0) {
                System.out.print(ind + " ");
            } else if ((-ind - 2) < 0) {
                System.out.print(0 + " ");
            } else if ((-ind - 2) >= 0) {
                if ((a[n - 1] - b[i]) < (b[i] - a[n - 2])) {
                    System.out.print(n - 1 + " ");
                } else {
                    System.out.print((-ind - 2) + " ");
                }
            } else {
                System.out.print(ind + " ");
            }
        }

    }
}
