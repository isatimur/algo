package com.learning.princeton.algo.client;

import com.learning.princeton.algo.impl.BruteCollinearPoints;
import com.learning.princeton.algo.impl.FastCollinearPoints;
import com.learning.princeton.algo.search.LineSegment;
import com.learning.princeton.algo.types.Point;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by abyakimenko on 20.11.2016.
 * <p>
 * Sample client. This client program takes the name of an input file as a command-line argument; read the input file
 * (in the format specified below); prints to standard output the line segments that your program discovers, one per
 * line; and draws to standard draw the line segments.
 */
public class client {

    public static void main(String[] args) {

        // read the n points from a file
        Point[] points = getPoints(args[0]);

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

//        executeBruteCollinearAlgo(points);
        executeFastCollinearAlgo(points);
    }

    private static void  executeBruteCollinearAlgo(Point[] points) {

        BruteCollinearPoints fastCollinearPoints = new BruteCollinearPoints(points);
        for (LineSegment segment : fastCollinearPoints.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

    private static void  executeFastCollinearAlgo(Point[] points) {

        FastCollinearPoints fastCollinearPoints = new FastCollinearPoints(points);
        for (LineSegment segment : fastCollinearPoints.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

    private static Point[] getPoints(String arg) {
        String basePath = "E:\\projects\\test_projects\\java\\LEARNING\\algo\\merge_quick_sort\\src\\main\\resources\\collinear\\";
        In in = new In(basePath + arg);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        return points;
    }
}
