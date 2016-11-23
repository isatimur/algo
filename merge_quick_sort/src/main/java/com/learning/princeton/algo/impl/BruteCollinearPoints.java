package com.learning.princeton.algo.impl;

import com.learning.princeton.algo.search.LineSegment;
import com.learning.princeton.algo.types.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Write a program BruteCollinearPoints.java that examines 4 points at a time and checks whether they all lie on the
 * same line segment, returning all such line segments. To check whether the 4 points p, q, r, and s are collinear,
 * check whether the three slopes between p and q, between p and r, and between p and s are all equal.
 * <p>
 * The method segments() should include each line segment containing 4 points exactly once. If 4 points appear on a
 * line segment in the order p→q→r→s, then you should include either the line segment p→s or s→p (but not both) and
 * you should not include subsegments such as p→r or q→r. For simplicity, we will not supply any input to
 * BruteCollinearPoints that has 5 or more collinear points.
 * <p>
 * Corner cases. Throw a java.lang.NullPointerException either the argument to the constructor is null or if any point
 * in the array is null. Throw a java.lang.IllegalArgumentException if the argument to the constructor contains
 * a repeated point.
 * <p>
 * Performance requirement. The order of growth of the running time of your program should be n4 in the worst case
 * and it should use space proportional to n plus the number of line segments returned.
 */
public class BruteCollinearPoints {

    private LineSegment[] segments;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {

        if (points == null) {
            throw new NullPointerException();
        }

        checkDuplicates(points);
        List<LineSegment> foundLineSegments = new ArrayList<>();

        Point[] pointsCopy = Arrays.copyOf(points, points.length);
        Arrays.sort(pointsCopy);

        // iterating
        for (int p = 0; p < points.length - 3; p++) {
            for (int q = p + 1; q < points.length - 2; q++) {
                for (int r = q + 1; r < points.length - 1; r++) {
                    for (int s = r + 1; s < points.length; s++) {

                        // p->q && p->r
                        // p->q && p->s
                        boolean pToQpToR = pointsCopy[p].slopeTo(pointsCopy[q]) == pointsCopy[p].slopeTo(pointsCopy[r]);
                        boolean pToQpToS = pointsCopy[p].slopeTo(pointsCopy[q]) == pointsCopy[p].slopeTo(pointsCopy[s]);
                        if (pToQpToR && pToQpToS) {
                            foundLineSegments.add(new LineSegment(pointsCopy[p], pointsCopy[s]));
                        }
                    }
                }
            }
        }

        segments = foundLineSegments.toArray(new LineSegment[foundLineSegments.size()]);
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.length;
    }

    // the line segments
    public LineSegment[] segments() {
        return Arrays.copyOf(segments, numberOfSegments());
    }

    // compare by pairs
    private void checkDuplicates(Point[] points) {

        for (int i = 0; i < points.length - 1; i++) {

            for (int j = i + 1; j < points.length; j++) {

                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Duplicate entries was found!");
                }
            }
        }
    }
}