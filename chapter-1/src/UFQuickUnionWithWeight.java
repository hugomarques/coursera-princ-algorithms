import java.util.Arrays;

/**
 * Created by hugomarques on 28/2/15.
 */
public class UFQuickUnionWithWeight {


    /**
     * Id array for each node.
     */
    private int[] ids;

    /**
     *
     */
    private int[] size;


    /**
     *
     */
    private int groups;

    /**
     * Default constructor
     * @param n set size
     */
    public UFQuickUnionWithWeight(final int n) {
        this.groups = n;
        ids = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
            size[i] = 1;
        }
    }

    private int root(final int id) {
        int rootId = id;
        while (rootId != ids[rootId]) {
            rootId = ids[rootId];
        }
        return rootId;
    }

    /**
     * Connect 2 elements to be part of the same group.
     * @param p First element.
     * @param q Second element.
     */
    public void union(final int p, final int q) {
        System.out.print("Union: ("+ p + ","+ q + "): ");
        final int rootP = root(p);
        final int rootQ = root(q);
        if (rootP != rootQ) {
            if (size[rootP] < size[rootQ]) {
                ids[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                ids[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            this.groups--;
        }
    }

    /**
     * Returns the group for which the element is inside.
     * @param p element id to be found.
     * @return id for the group of that element.
     */
    public int find(final int p) {
        return root(p);
    }

    /**
     * Determines if 2 elements are part of the same group.
     * @param p id for first element.
     * @param q id for second element.
     * @return true if they have the same id, false otherwise.
     */
    public boolean connected(final int p, final int q) {
        return root(p) == root(q);
    }

    /**
     * Number of different groups existing on this data structure.
     * @return
     */
    public int count() {
        return this.groups;
    }

    @Override
    public String toString() {
        return Arrays.toString(ids) + " \n Size: " + Arrays.toString(size);
    }

    /**
     *
     * @param expected
     */
    public static void expect(final boolean expected) {
        System.out.println("UFQuickFind.expect:" + expected);
    }

    /**
     * Main method.
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        final UFQuickUnionWithWeight UFQuickFind = new UFQuickUnionWithWeight(10);
        UFQuickFind.union(4, 3);
        System.out.println(UFQuickFind.toString());
        UFQuickFind.union(3, 8);
        System.out.println(UFQuickFind.toString());
        UFQuickFind.union(6, 5);
        System.out.println(UFQuickFind.toString());
        UFQuickFind.union(9, 4);
        System.out.println(UFQuickFind.toString());
        UFQuickFind.union(2, 1);
        System.out.println(UFQuickFind.toString());

        expect(false == UFQuickFind.connected(5, 0));
        UFQuickFind.union(5, 0);
        System.out.println(UFQuickFind.toString());
        UFQuickFind.union(7, 2);
        System.out.println(UFQuickFind.toString());
        UFQuickFind.union(6, 1);
        System.out.println(UFQuickFind.toString());

        expect(true == UFQuickFind.connected(8, 9));
        expect(true == UFQuickFind.connected(5, 0));
        expect(true == UFQuickFind.connected(6, 0));
        expect(true == UFQuickFind.connected(1, 0));
        expect(UFQuickFind.count() == 2);
    }

}
