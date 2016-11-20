package com.learning.princeton.algo.impl;

import com.learning.princeton.algo.search.LineSegment;
import com.learning.princeton.algo.types.Point;

/**
 * A faster, sorting-based solution. Remarkably, it is possible to solve the problem much faster than the brute-force
 * solution described above. Given a point p, the following method determines whether p participates in a set of 4
 * or more collinear points.

 Think of p as the origin.
 For each other point q, determine the slope it makes with p.
 Sort the points according to the slopes they makes with p.
 Check if any 3 (or more) adjacent points in the sorted order have equal slopes with respect to p. If so, these points,
 together with p, are collinear.
 Applying this method for each of the n points in turn yields an efficient algorithm to the problem. The algorithm
 solves the problem because points that have equal slopes with respect to p are collinear, and sorting brings such
 points together. The algorithm is fast because the bottleneck operation is sorting.
 */
public class FastCollinearPoints {

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {

    }

    // the number of line segments
    public int numberOfSegments() {

        return 0;
    }

    // the line segments
    public LineSegment[] segments(){

        return new LineSegment[0];
    }
}