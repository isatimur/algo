package com.isatimur.package_1_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Isachenko Timur on 11.10.2016.
 */
public class Main {

    private static List<Integer> integers = new ArrayList<>();
    private static int N = 0;

    public static void main(String[] args) {
        int inputParam = new Scanner(System.in).nextInt();

        N = inputParam;
        if (inputParam > 0) {
            collectPrimeNumbers(inputParam);
            System.out.println(integers.stream().map(s -> String.valueOf(s)).collect(Collectors.joining(" ")));
        }
    }

    public static void collectPrimeNumbers(int n) {
        for (int i = 2; (i * i) <= n; ++i) {
            if (n % i == 0) {
                n = n / i;
                integers.add(i);
                --i;
            }
        }
        if (isPrime(n)) {
            integers.add(n);

        }
    }

    private static boolean isPrime(int n) {
        if (n == 1)
            return false;

        for (int i = 2; (i * i) <= n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }

}
