package com.learning.princeton.algo.sort;

import static com.learning.princeton.algo.helpers.Helpers.exch;
import static com.learning.princeton.algo.helpers.Helpers.less;

/**
 * Created by abyakimenko on 13.11.2016.
 * <p>
 * Этапы алгоритма:
 * <p>
 * Инициализация: задание начального значения {\displaystyle d} d — которое впоследствии будет уменьшаться (о выборе значения {\displaystyle d} d см. ниже);
 * Основная часть:
 * Упорядочение массива:
 * Выбор пары элементов, индексы которых отличаются на {\displaystyle d} d;
 * Определение разности элементов выбранной пары;
 * Упорядочение элементов в рамках пары согласно разности значений;
 * Переход к следующей паре;
 * Уменьшение значения {\displaystyle d} d;
 * Проверка: если {\displaystyle d>0} {\displaystyle d>0} — вернуться к пункту "1" основной части (и если {\displaystyle d=1} d=1 — для проведения обычной сортировки вставками);
 * Завершение работы (например, вывод результатов на экран).
 */
public class ShellSort {

    public static void executeSorting(Comparable[] arrayOfInts) {

        if (arrayOfInts == null) {
            throw new RuntimeException("Can't sort null array. Array is null!!!");
        }

        int length = arrayOfInts.length;
        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(arrayOfInts[j], arrayOfInts[j - h]); j -= h) {
                    exch(arrayOfInts, j, j - h);
                }
            }
//            assert isHsorted(arrayOfInts, h);
            h /= 3;
        }
//        assert isSorted(arrayOfInts);
    }
}
