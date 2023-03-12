/* *****************************************************************************
 *  Name:              Oleksandr Klymenko
 *  Coursera User ID:  f4bfa59164f7dd3a6b9cded066671150
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final WeightedQuickUnionUF uf;
    private final int n;
    private int[] openSites;
    private int numberOfOpenSited = 0;


    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Wrong argument!");
        }
        uf = new WeightedQuickUnionUF(n * n + 2);
        openSites = new int[n * n];
        for (int i = 0; i < n; i++) {
            uf.union(i, n * n);
            uf.union(n * n - i - 1, n * n + 1);
        }
        this.n = n;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            int p = getPosition(row, col);
            openSites[p] = 1;
            numberOfOpenSited++;
            // try connecting to upper site
            if (row != 1 && isOpen(row - 1, col)) {
                int upperP = getPosition(row - 1, col);
                uf.union(p, upperP);
            }
            // try connecting to left site
            if (col != 1 && isOpen(row, col - 1)) {
                int leftP = getPosition(row, col - 1);
                uf.union(p, leftP);
            }
            // try connecting to right site
            if (col != n && isOpen(row, col + 1)) {
                int rightP = getPosition(row, col + 1);
                uf.union(p, rightP);
            }
            // try connecting to under site
            if (row != n && isOpen(row + 1, col)) {
                int underP = getPosition(row + 1, col);
                uf.union(p, underP);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int p = getPosition(row, col);
        return openSites[p] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int p = getPosition(row, col);
        return uf.find(p) == uf.find(n * n) && openSites[p] == 1;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSited;
    }

    // does the system percolate?
    public boolean percolates() {
        for (int i = 0; i < n * n; i++) {
            boolean isOpen = openSites[i] == 1;
            StdOut.print(isOpen ? "\uD83D\uDFE6 " : "\uD83D\uDFE9 ");
            if ((i + 1) % n == 0) {
                StdOut.println();
            }
        }
        StdOut.println();
        int bottom = uf.find(n * n + 1);
        boolean result = uf.find(n * n) == bottom;
        return result;
    }

    private int getPosition(int row, int col) {
        if (row <= 0 || row > n || col <= 0 || col > n) {
            throw new IllegalArgumentException("Wrong arguments: " + row + " " + col);
        }
        int p = (col - 1) + (row - 1) * n;
        return p;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 3);
        StdOut.println(percolation.isFull(3, 1));
        percolation.open(2, 3);
        StdOut.println(percolation.isFull(3, 1));
        percolation.open(3, 3);
        StdOut.println(percolation.isFull(3, 1));
        percolation.open(3, 1);
        StdOut.println(percolation.isFull(3, 1));
        StdOut.println(percolation.percolates());


    }


}
