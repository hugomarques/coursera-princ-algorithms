import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * @author hugomarques
 *         1/27/17.
 */
public class Percolation {

    private boolean[] indexStatus;
    private int openSites;

    private int virtualTop;
    private int virtualBottom;

    private int n;

    private WeightedQuickUnionUF weightedQuickUnionUF;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("N can't be lesser than 1.");
        this.n = n;
        this.weightedQuickUnionUF = new WeightedQuickUnionUF(n*n+2);
        this.indexStatus = new boolean[n*n+2];
        virtualTop = n*n;
        virtualBottom = n*n+1;
        for (int i = 0; i < n*n; i++) {
            this.indexStatus[i] = false;
        }
        this.indexStatus[virtualTop] = true;

        this.indexStatus[virtualBottom] = true;

        this.openSites = 0;
    }

    public void open(int row, int col) {
        validateCoordinates(row, col);
        if (isOpen(row, col)) return;
        int indexPos = getPosition(row, col);
        indexStatus[indexPos] = true;
        // is up open?
        if (row != 1 && isOpen(row-1, col)) {
            int up = getPosition(row - 1, col);
            this.weightedQuickUnionUF.union(indexPos, up);
        } else if (row == 1) { // Connect with top
            this.weightedQuickUnionUF.union(indexPos, virtualTop);
        }
        // is right open?
        if (col < n && isOpen(row, col+1)) {
            int right = getPosition(row, col + 1);
            this.weightedQuickUnionUF.union(indexPos, right);
        }
        // is bottom open?
        if (row < n && isOpen(row+1, col)) {
            int down = getPosition(row + 1, col);
            this.weightedQuickUnionUF.union(indexPos, down);
        } else if (row == n) {
            this.weightedQuickUnionUF.union(indexPos, virtualBottom);
        }
        // is left open?
        if (col > 1 && isOpen(row, col-1)) {
            int left = getPosition(row, col-1);
            this.weightedQuickUnionUF.union(indexPos, left);
        }
        this.openSites++;
    }

    public boolean isOpen(int row, int col) {
        validateCoordinates(row, col);
        return indexStatus[getPosition(row, col)];
    }

    public boolean isFull(int row, int col) {
        validateCoordinates(row, col);
        return this.weightedQuickUnionUF.connected(virtualTop, getPosition(row, col));
    }

    public int numberOfOpenSites() {
        return this.openSites;
    }


    public boolean percolates() {
        return this.weightedQuickUnionUF.connected(virtualTop, virtualBottom);
    }

    private int getPosition(int row, int col) {
        validateCoordinates(row, col);
        return n*(row-1) + col-1;
    }

    private void validateCoordinates(int row, int col) {
        if (row <= 0 || row > n) throw new IndexOutOfBoundsException(String.format("row must be between 1 and %s", n));
        if (col <= 0 || col > n) throw new IndexOutOfBoundsException(String.format("col must be between 1 and %s", n));
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);
        System.out.println(percolation.getPosition(1, 1));
        System.out.println(percolation.getPosition(1, 2));
        System.out.println(percolation.getPosition(1, 3));
        System.out.println(percolation.getPosition(2, 1));
        System.out.println(percolation.getPosition(2, 2));
        System.out.println(percolation.getPosition(2, 3));
        System.out.println(percolation.getPosition(3, 1));
        System.out.println(percolation.getPosition(3, 2));
        System.out.println(percolation.getPosition(3, 3));
        System.out.println("Done building.");
        percolation.open(1, 1);
        percolation.open(2, 1);
        percolation.open(2, 2);
        percolation.open(2, 3);

        System.out.println(percolation.isFull(2, 2));
        System.out.println(percolation.percolates());
    }
}
