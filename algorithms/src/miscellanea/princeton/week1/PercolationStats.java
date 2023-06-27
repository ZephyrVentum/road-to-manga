import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/* *****************************************************************************
 *  Name:              Oleksandr Klymenko
 *  Coursera User ID:  f4bfa59164f7dd3a6b9cded066671150
 *  Last modified:     October 16, 1842
 **************************************************************************** */
public class PercolationStats {

    private static final double CONFIDENCE_95 = 1.96;
    private final int T;
    private final double[] thresholds;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Wrong arguments!");
        }
        else {
            T = trials;
            thresholds = new double[trials];
            for (int i = 0; i < trials; i++) {
                Percolation percolation = new Percolation(n);
                while (!percolation.percolates()) {
                    int row = StdRandom.uniform(n) + 1;
                    int col = StdRandom.uniform(n) + 1;
                    percolation.open(row, col);
                }
                // StdOut.println("________");
                thresholds[i] = (double) percolation.numberOfOpenSites() / (n * n);
            }
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (CONFIDENCE_95 * stddev() / Math.sqrt(T));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (CONFIDENCE_95 * stddev() / Math.sqrt(T));
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats percolationStats = new PercolationStats(Integer.parseInt(args[0]),
                                                                 Integer.parseInt(args[1]));
        StdOut.println("mean                    = " + percolationStats.mean());
        StdOut.println("stddev                  = " + percolationStats.stddev());
        StdOut.println("95% confidence interval = [" + percolationStats.confidenceLo() + ", "
                               + percolationStats.confidenceHi() + "]");
    }

}
