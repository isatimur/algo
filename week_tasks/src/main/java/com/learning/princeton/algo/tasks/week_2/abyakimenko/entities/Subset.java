package com.learning.princeton.algo.tasks.week_2.abyakimenko.entities;

import edu.princeton.cs.algs4.StdIn;

/**
 * Subset client. Write a client program Subset.java that takes a command-line integer k; reads in a sequence of N strings
 * from standard input using StdIn.readString(); and prints out exactly k of them, uniformly at random. Each item from
 * the sequence can be printed out at most once. You may assume that 0 ≤ k ≤ n, where n is the number of string on
 * standard input.
 * <p>
 * % echo A B C D E F G H I | java Subset 3       % echo AA BB BB BB BB BB CC CC | java Subset 8
 * C                                              BB
 * G                                              AA
 * A                                              BB
 * CC
 * % echo A B C D E F G H I | java Subset 3       BB
 * E                                              BB
 * F                                              CC
 * G                                              BB
 * The running time of Subset must be linear in the size of the input. You may use only a constant amount of memory plus
 * either one Deque or RandomizedQueue object of maximum size at most n, where n is the number of strings on standard input.
 * (For an extra challenge, use only one Deque or RandomizedQueue object of maximum size at most k.) It should have the
 * following API.
 * public class Subset {
 * public static void main(String[] args)
 * }
 * <p>
 * <p>
 * (Результаты)
 * Deliverables. Submit only Deque.java, RandomizedQueue.java, and Subset.java. We will supply algs4.jar.
 * Your submission not call library functions except those in StdIn, StdOut, StdRandom, java.lang, java.util.Iterator,
 * and java.util.NoSuchElementException. In particular, you may not use either java.util.LinkedList or java.util.ArrayList.
 */
public class Subset {

    public static void main(String[] args) {

        if (args == null || args.length == 0) {
            throw new RuntimeException("Arguments are empty!");
        }

        int k = Integer.parseInt(args[0]);
        int n = k;

        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();

        while (!StdIn.isEmpty()) {
            String string = StdIn.readString();
            randomizedQueue.enqueue(string);
        }

        print(randomizedQueue, k);
    }

    private static void print(RandomizedQueue<String> randomizedQueue, int k) {
        for (int i = 0; i < k; i++) {
            System.out.println(randomizedQueue.dequeue());
        }
    }
}