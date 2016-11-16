package com.learning.princeton.algo.tasks.week_2.yandex.banner;

import java.util.Random;

public class Banner {
    public static void main(String[] args) {

        int length = 10;
        Random r = new Random();
        int[] list = new int[length];// в угоду наглядности в дебри линкедлистов лезть не будем
        for (int i = 0; i < length; ++i) {
            list[i] = i;
        }
        /*А теперь главное - логика алгоритма*/
        int index = length - 1;
        int number;
        while (index > 0) {
            number = r.nextInt(index);
            System.out.print(list[number] + " ");
            list[number] = list[index];
            --index;
        }
    }
}