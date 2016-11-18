package com.learning.princeton.algo.tasks.week_2.deikstra;

import java.util.Stack;

/**
 * Created by abyakimenko on 18.11.2016.
 */
public class DeikstraDoubleStack {

    public static void main(String[] args) {

        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        String example = "(1 + ( (2 + 3) * (4 * 5) ) )";

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
