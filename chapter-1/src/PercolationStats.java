import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * @author hugomarques
 *         1/27/17.
 */
public class PercolationStats {

    /**
     * Site of grids
     */
    private final int n;

    /**
     * Number of trials
     */
    private final int trials;

    /**
     * Experiment results.
     */
    private double[] percolateThresholds;

    /**
     * perform trials independent experiments on an n-by-n grid
     * @param n
     * @param trials
     */
    public PercolationStats(int n, int trials) {
        this.n = n;
        this.trials = trials;
        if (n <= 0 || trials <= 0){
            throw new IllegalArgumentException("Input values can't be <= 0.");
        }
        percolateThresholds = new double[trials];
        for (int i = 0; i < trials; i++){
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int x = StdRandom.uniform(1,n + 1);
                int y = StdRandom.uniform(1,n + 1);
                if (!percolation.isOpen(x, y)) {
                    percolation.open(x, y);
                }
            }
            percolateThresholds[i] = (double)percolation.numberOfOpenSites()/(n*n);
        }

    }

    /**
     * perform trials independent experiments on an n-by-n grid
     * @return
     */
    public double mean() {
            return StdStats.mean(percolateThresholds);
        } // sample mean of percolation threshold

    /**
     * sample standard deviation of percolation threshold
     * @return
     */
    public double stddev()  {
            return StdStats.stddev(percolateThresholds);
        }

    /**
     * low  endpoint of 95% confidence interval
     * @return
     */
    public double confidenceLo()  {
        return this.mean() - (1.96 * stddev()) / Math.sqrt(trials);
    }

    /**
     * high endpoint of 95% confidence interval
     * @return
     */
    public double confidenceHi() {
        return this.mean() + (1.96 * stddev()) / Math.sqrt(trials);
    }

    /**
     * Main method. See: http://coursera.cs.princeton.edu/algs4/assignments/percolation.html for details.
     * @param args
     */
    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);
        int trials = Integer.valueOf(args[1]);
        final PercolationStats percolationStats = new PercolationStats(n, trials);
        StdOut.printf("mean                    = %.10f\n", percolationStats.mean());
        StdOut.printf("stddev                  = %.10f\n", percolationStats.stddev());
        StdOut.printf("95%% confidence interval = [%.10f, %.10f]\n",
                percolationStats.confidenceLo(), percolationStats.confidenceHi());
    }
}
