package com.learning.princeton.algo.impl;

import com.learning.princeton.algo.search.LineSegment;
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
    private HashMap<Double, List<Point>> segmentsMap = new HashMap<>();
    private HashMap<Double, List<Point>> resultMap = new HashMap<>();

    private List<LineSegment> segments = new ArrayList<>();

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {

        checkDuplicates(points);

        Point[] pointsCopy = Arrays.copyOf(points, points.length);
        List<Point> slopePointMap = new ArrayList<>();

        for (Point pointQ : points) {

            HashMap<Double, Set<Point>> slopesMap = new HashMap<>();

            // - For each other point q, determine the slope it makes with p.
            // - Sort the points according to the slopes they makes with p.
            Arrays.sort(pointsCopy, pointQ.slopeOrder());

            List<Point> slopePoints = new ArrayList<>();
            double slope;
            double previousSlope = Double.NEGATIVE_INFINITY;

            for (int i = 1; i < pointsCopy.length; i++) {

                slope = pointQ.slopeTo(pointsCopy[i]);

                final Point currentPoint = pointsCopy[i];
                if (slopesMap.get(slope) == null) {

                    slopesMap.put(slope, new HashSet<Point>() {{
                        add(pointsCopy[0]);
                        add(currentPoint);
                    }});

                } else {
                    slopesMap.get(slope).add(currentPoint);
                }

                // slopes are equals
                if (slope == previousSlope) {
                    slopePoints.add(pointsCopy[i]);
                } else {
                    // check if slopePoints has already had three or more points
                    if (slopePoints.size() >= 3) {
                        slopePoints.add(pointQ);
                        addNewSegment(slopePoints, previousSlope);
                    }
                    slopePoints.clear();
                    slopePoints.add(pointsCopy[i]);
                }
                previousSlope = slope;
            }

            // fill map
            for (Map.Entry<Double, Set<Point>> entrySet : slopesMap.entrySet()) {

                if (entrySet.getValue().size() >= 3) {
                    resultMap.put(entrySet.getKey(), new ArrayList<>(entrySet.getValue()));
                }
            }
        }


        // sort points
        for (Map.Entry<Double, List<Point>> entrySet : resultMap.entrySet()) {
            Collections.sort(entrySet.getValue());
        }
    }

    private void addNewSegment(List<Point> slopePoints, double slope) {
        List<Point> endPoints = segmentsMap.get(slope);
        Collections.sort(slopePoints);

        Point startPoint = slopePoints.get(0);
        Point endPoint = slopePoints.get(slopePoints.size() - 1);

        if (endPoints == null) {
            endPoints = new ArrayList<>();
            endPoints.add(endPoint);
            segmentsMap.put(slope, endPoints);
            segments.add(new LineSegment(startPoint, endPoint));
        } else {
            for (Point currentEndPoint : endPoints) {
                if (currentEndPoint.compareTo(endPoint) == 0) {
                    return;
                }
            }
            endPoints.add(endPoint);
            segments.add(new LineSegment(startPoint, endPoint));
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