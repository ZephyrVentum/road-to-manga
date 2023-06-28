/* *****************************************************************************
 *  Name:              Oleksandr Klymenko
 *  Coursera User ID:  f4bfa59164f7dd3a6b9cded066671150
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FastCollinearPoints {

    private ArrayList<LineSegment> segments;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        List<Point> sortedPoints = new ArrayList<>(Arrays.asList(points));
        segments = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            Point pPoint = points[i];
            if (pPoint != null) {
                sortedPoints.remove(pPoint);
            }
            boolean wasRemoved = sortedPoints.removeIf(Objects::isNull);
            if (i == 0 && wasRemoved) {
                throw new IllegalArgumentException();
            }
            sortedPoints.sort(pPoint.slopeOrder());

            // StdOut.print(pPoint.toString() + " | ");
            // for (Point point : sortedPoints) {
            //     StdOut.print(String.format("%s  ", point));
            // }
            // StdOut.println();
            // StdOut.print("                  ");
            // for (Point point : sortedPoints) {
            //     StdOut.print(String.format("%.6f  ", pPoint.slopeTo(point)));
            // }
            // StdOut.println();

            findLineSegments(pPoint, sortedPoints);
        }
    }

    private void findLineSegments(Point pPoint, List<Point> sortedPoints) {
        int counter = 0;
        double targetSlope = Double.NEGATIVE_INFINITY;
        int start = -1;
        boolean hasFound = false;
        for (int i = 0; i < sortedPoints.size(); i++) {
            Point sortedPoint = sortedPoints.get(i);
            double currentSlope = pPoint.slopeTo(sortedPoint);
            if (currentSlope == Double.NEGATIVE_INFINITY) {
                throw new IllegalArgumentException();
            }
            if (targetSlope == currentSlope) {
                if (start == -1) {
                    start = i;
                }
                counter++;
            }
            else {
                if (counter >= 3) {
                    createLineSegment(pPoint, sortedPoints, start, i - 1);
                    hasFound = true;
                }
                targetSlope = currentSlope;
                start = i;
                counter = 1;
            }
        }
        if (counter >= 3) {
            createLineSegment(pPoint, sortedPoints, start, sortedPoints.size() - 1);
            hasFound = true;
        }
        if (!hasFound) {
            sortedPoints.add(pPoint);
        }
    }

    private void createLineSegment(Point pPoint, List<Point> sortedPoints, int start, int end) {
        // StdOut.println("Collinear!");
        // StdOut.println();
        List<Point> subList = sortedPoints.subList(start, end + 1);
        subList.sort(Point::compareTo);
        Point startPoint = subList.get(0);
        Point endPoint = subList.get(subList.size() - 1);
        Point min = pPoint.compareTo(startPoint) < 0 ? pPoint : startPoint;
        Point max = pPoint.compareTo(endPoint) > 0 ? pPoint : endPoint;
        segments.add(new LineSegment(min, max));
        for (int i = start; i <= end; i++) {
            sortedPoints.set(i, null);
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.size();
    }

    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[0]);
    }

    // private static void sort(Point[] a, Comparator<Point> comparator) {
    //     Point[] aux = a.clone();
    //     sort(aux, a, 0, a.length - 1, comparator);
    // }
    //
    // private static void merge(Point[] src, Point[] dst, int lo, int mid, int hi,
    //                           Comparator<Point> comparator) {
    //
    //     int i = lo, j = mid + 1;
    //     for (int k = lo; k <= hi; k++) {
    //         if (i > mid) dst[k] = src[j++];
    //         else if (j > hi) dst[k] = src[i++];
    //         else if (less(src[j], src[i], comparator)) dst[k] = src[j++];
    //         else dst[k] = src[i++];
    //     }
    // }
    //
    //
    // private static void sort(Point[] src, Point[] dst, int lo, int hi,
    //                          Comparator<Point> comparator) {
    //     if (hi <= lo) return;
    //     int mid = lo + (hi - lo) / 2;
    //     sort(dst, src, lo, mid, comparator);
    //     sort(dst, src, mid + 1, hi, comparator);
    //
    //     // using System.arraycopy() is a bit faster than the above loop
    //     if (!less(src[mid + 1], src[mid], comparator)) {
    //         System.arraycopy(src, lo, dst, lo, hi - lo + 1);
    //         return;
    //     }
    //
    //     merge(src, dst, lo, mid, hi, comparator);
    // }
    //
    // private static boolean less(Point a, Point b, Comparator<Point> comparator) {
    //     return comparator.compare(a, b) < 0;
    // }

    public static void main(String[] args) {
        /* YOUR CODE HERE */
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        // int n = 9;
        Point[] points = new Point[n];
        // points[0] = new Point(10000, 0);
        // points[1] = new Point(0, 10000);
        // points[2] = new Point(3000, 7000);
        // points[3] = new Point(7000, 3000);
        // points[4] = new Point(20000, 21000);
        // points[5] = new Point(3000, 4000);
        // points[6] = new Point(14000, 15000);
        // points[7] = new Point(6000, 7000);
        // points[8] = new Point(1000, 1000);
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        StdDraw.setPenRadius(0.015);
        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
            StdOut.println(p.toString());
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
