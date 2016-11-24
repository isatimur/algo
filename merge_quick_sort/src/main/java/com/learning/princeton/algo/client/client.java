package com.learning.princeton.algo.client;

import com.learning.princeton.algo.impl.BruteCollinearPoints;
import com.learning.princeton.algo.impl.FastCollinearPoints;
import com.learning.princeton.algo.types.LineSegment;
import com.learning.princeton.algo.types.Point;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abyakimenko on 20.11.2016.
 * <p>
 * Sample client. This client program takes the name of an input file as a command-line argument; read the input file
 * (in the format specified below); prints to standard output the line segments that your program discovers, one per
 * line; and draws to standard draw the line segments.
 */
public class client {

    private static final String basePath = "E:\\projects\\test_projects\\java\\LEARNING\\algo\\merge_quick_sort\\src\\main\\resources\\collinear\\";

    public static void main(String[] args) throws InterruptedException {

        List<String> stringList = fileList(basePath);

        // read the n points from a file
//        for (String path : stringList) {
//
//            System.out.println(path.toString());
//
//            Point[] points = getPoints(path);
//
//            // draw the points
//            StdDraw.enableDoubleBuffering();
//            StdDraw.setXscale(0, 32768);
//            StdDraw.setYscale(0, 32768);
//            for (Point p : points) {
//                p.draw();
//            }
//            StdDraw.show();
//
//            executeFastCollinearAlgo(points);
//
//            Thread.sleep(5000);
//            StdDraw.clear();
//        }


        Point[] points = getPoints(basePath + args[0]);

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

    private static void executeBruteCollinearAlgo(Point[] points) {

        BruteCollinearPoints fastCollinearPoints = new BruteCollinearPoints(points);
        for (LineSegment segment : fastCollinearPoints.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

    private static void executeFastCollinearAlgo(Point[] points) {

        FastCollinearPoints fastCollinearPoints = new FastCollinearPoints(points);
        System.out.println(fastCollinearPoints.segments().length + " was found");
        for (LineSegment segment : fastCollinearPoints.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

    private static Point[] getPoints(String arg) {

        In in = new In(arg);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        return points;
    }

    private static List<String> fileList(String directory) {

        List<String> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {
                if (path.toString().contains(".txt")) fileNames.add(path.toString());
            }
        } catch (IOException ex) {
        }
        return fileNames;
    }
}
