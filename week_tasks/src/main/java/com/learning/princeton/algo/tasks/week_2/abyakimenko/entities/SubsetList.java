package com.learning.princeton.algo.tasks.week_2.abyakimenko.entities;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetList {

    private SubsetList() {
    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        List<String> queue = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            queue.add(StdIn.readString());
        }
        Collections.shuffle(queue);
        for (int i = 0; i < k; i++) {
            StdOut.println(queue.get(i));
        }
    }
}