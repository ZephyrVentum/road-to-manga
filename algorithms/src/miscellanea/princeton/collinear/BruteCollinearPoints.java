/* *****************************************************************************
 *  Name:              Oleksandr Klymenko
 *  Coursera User ID:  f4bfa59164f7dd3a6b9cded066671150
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class BruteCollinearPoints {
    private ArrayList<LineSegment> segments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        segments = new ArrayList<>();
        for (int p = 0; p < points.length; p++) {
            Point pPoint = points[p];
            if (pPoint == null) {
                throw new IllegalArgumentException();
            }
            for (int q = p + 1; q < points.length; q++) {
                Point qPoint = points[q];
                if (qPoint == null) {
                    throw new IllegalArgumentException();
                }
                if (pPoint.compareTo(qPoint) == 0) {
                    throw new IllegalArgumentException();
                }
                for (int r = q + 1; r < points.length; r++) {
                    Point rPoint = points[r];
                    if (rPoint == null) {
                        throw new IllegalArgumentException();
                    }
                    if (qPoint.compareTo(rPoint) == 0) {
                        throw new IllegalArgumentException();
                    }
                    for (int s = r + 1; s < points.length; s++) {
                        Point sPoint = points[s];
                        if (sPoint == null) {
                            throw new IllegalArgumentException();
                        }
                        if (rPoint.compareTo(sPoint) == 0) {
                            throw new IllegalArgumentException();
                        }

                        double pToQ = pPoint.slopeTo(qPoint);
                        double pToR = pPoint.slopeTo(rPoint);
                        double pToS = pPoint.slopeTo(sPoint);

                        // StdOut.println(String.format("P%s, Q%s, R%s, S%s", pPoint.toString(),
                        //                              qPoint.toString(), rPoint.toString(),
                        //                              sPoint.toString()));
                        //
                        // StdOut.println(String.format("pToQ: %s\npToR: %s\npToS: %s", pToQ, pToR,
                        //                              pToS));

                        if (pToQ == pToR && pToQ == pToS) {
                            // StdOut.println("Collinear!");
                            createLineSegment(pPoint, qPoint, rPoint, sPoint);
                        }
                        // StdOut.println("");
                    }
                }
            }
        }

    } // finds all line segments containing 4 points

    private void createLineSegment(Point pPoint, Point qPoint, Point rPoint, Point sPoint) {
        int pToQ = pPoint.compareTo(qPoint);
        int rToS = rPoint.compareTo(sPoint);

        Point firstMax = pToQ > 0 ? pPoint : qPoint;
        Point secondMax = rToS > 0 ? rPoint : sPoint;

        Point firstMin = pToQ < 0 ? pPoint : qPoint;
        Point secondMin = rToS < 0 ? rPoint : sPoint;

        int maxToMax = firstMax.compareTo(secondMax);
        int minToMin = firstMin.compareTo(secondMin);

        Point max = maxToMax > 0 ? firstMax : secondMax;
        Point min = minToMin < 0 ? firstMin : secondMin;

        segments.add(new LineSegment(max, min));
    }

    public int numberOfSegments() {
        return segments.size();
    }    // the number of line segments

    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[0]);
    }

    public static void main(String[] args) {
        /* YOUR CODE HERE */
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    } // the line segments
}
