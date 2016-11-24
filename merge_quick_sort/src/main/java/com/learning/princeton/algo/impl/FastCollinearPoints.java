package com.learning.princeton.algo.impl;

import com.learning.princeton.algo.types.LineSegment;
import com.learning.princeton.algo.types.Point;

import java.util.*;

/**
 * A faster, sorting-based solution. Remarkably, it is possible to solve the problem much faster than the brute-force
 * solution described above. Given a point p, the following method determines whether p participates in a set of 4
 * or more collinear points.
 * <p>
 * Think of p as the origin.
 * - For each other point q, determine the slope it makes with p.
 * - Sort the points according to the slopes they makes with p.
 * - Check if any 3 (or more) adjacent points in the sorted order have equal slopes with respect to p. If so, these points,
 * together with p, are collinear.
 * <p>
 * !!!
 * Applying this method for each of the n points in turn yields an efficient algorithm to the problem.
 * !!!
 * <p>
 * The algorithm
 * solves the problem because points that have equal slopes with respect to p are collinear, and sorting brings such
 * points together. The algorithm is fast because the bottleneck operation is sorting.
 */
public class FastCollinearPoints {

    // we can group segments by slope
    private HashMap<Double, List<Point>> resultMap = new HashMap<>();

    private List<LineSegment> segments = new ArrayList<>();

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {

        checkDuplicates(points);
        Point[] pointsCopy = Arrays.copyOf(points, points.length);

        for (Point pointQ : points) {

            HashMap<Double, Set<Point>> slopesMap = new HashMap<>();

            // - For each other point q, determine the slope it makes with p.
            // - Sort the points according to the slopes they makes with p.
            Arrays.sort(pointsCopy, pointQ.slopeOrder());

            for (int i = 1; i < pointsCopy.length; i++) {

                final Point currentPoint = pointsCopy[i];
                double slope = pointQ.slopeTo(currentPoint);

                if (slopesMap.get(slope) == null) {

                    HashSet<Point> pointSet = new HashSet<>();
                    pointSet.add(pointsCopy[0]);
                    pointSet.add(currentPoint);

                    slopesMap.put(slope, pointSet);

                } else {
                    slopesMap.get(slope).add(currentPoint);
                }

                // fill map
                for (Map.Entry<Double, Set<Point>> entrySet : slopesMap.entrySet()) {

                    if (entrySet.getValue().size() >= 3) {
                        // sort points inside segments
                        List<Point> tmpList = new ArrayList<>(entrySet.getValue());
                        Collections.sort(tmpList);
                        resultMap.put(entrySet.getKey(), Arrays.asList(tmpList.get(0), tmpList.get(tmpList.size() - 1)));
                    }
                }
            }
        }

        fillSegments();
    }

    private void fillSegments() {

        for (Map.Entry<Double, List<Point>> entrySet : resultMap.entrySet()) {

            List<Point> tmpList = entrySet.getValue();
            segments.add(new LineSegment(tmpList.get(0), tmpList.get(tmpList.size() - 1)));
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.size();
    }

    // the line segments
    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[numberOfSegments()]);
    }

    private void checkDuplicates(Point[] points) {

        if (points == null) throw new NullPointerException();

        for (int i = 0; i < points.length - 1; i++) {

            if (points[i] == null) throw new NullPointerException();
            for (int j = i + 1; j < points.length; j++) {

                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Duplicate entries was found!");
                }
            }
        }
    }
}