package com.learning.princeton.algo.tasks.week_2.deikstra;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * Created by abyakimenko on 18.11.2016.
 */
public class DeikstraDoubleStack {

    public static void main(String[] args) {

        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();


        int n = 50;

        edu.princeton.cs.algs4.Stack<Integer> stack = new edu.princeton.cs.algs4.Stack<>();
        while (n > 0) {
            stack.push(n % 2);
            n = n / 2;
        }

        stack.forEach(StdOut::print);

        StdOut.println();


//        String example = "(1 + ( (2 + 3) * (4 * 5) ) )";
        String example = "(1 + ( (2 + 3) + (4 * 5)  + 3 * 5 ) )";



        char[] exampleChar = example.replaceAll("\\s", "").toCharArray();

        for (char s : exampleChar) {

            if (s == '(') {

            } else if (s == '+') {
                ops.push(String.valueOf(s));
            } else if (s == '*') {
                ops.push(String.valueOf(s));
            } else if (s == ')') {

                String op = ops.pop();

                if (op.equals("+")) {
                    vals.push(vals.pop() + vals.pop());
                } else if (op.equals("*")) {
                    vals.push(vals.pop() * vals.pop());
                }
            } else {
                Double pushVal = Double.parseDouble(String.valueOf(s));
                vals.push(pushVal);
            }
        }

        System.out.println(vals.pop());

    }
}
