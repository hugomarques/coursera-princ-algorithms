import java.util.Arrays;

/**
 * Quick find algorithm that describes if 2 ids are connected.
 * union O(N)
 * find worst case O(N)
 */
public class UFQuickUnion {

    /**
     *
     */
    private int[] ids;

    /**
     *
     */
    private int n;

    /**
     *
     */
    private int groups;

    /**
     * Default constructor
     * @param n set size
     */
    public UFQuickUnion(final int n) {
        this.n = n;
        this.groups = n;
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
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
     * @param pId First element.
     * @param qId Second element.
     */
    public void union(final int pId, final int qId) {
        System.out.print("Union: ("+ pId + ","+ qId + "): ");
        final int pIdRoot = root(pId);
        final int qIdRoot = root(qId);
        if (pIdRoot != qIdRoot) {
            ids[pIdRoot] = qIdRoot;
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
        return Arrays.toString(ids);
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
        final UFQuickUnion UFQuickFind = new UFQuickUnion(10);
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

        UFQuickFind.union(5, 0);
        System.out.println(UFQuickFind.toString());
        UFQuickFind.union(7, 2);
        System.out.println(UFQuickFind.toString());
        UFQuickFind.union(6, 1);
        System.out.println(UFQuickFind.toString());

        expect(UFQuickFind.connected(8, 9));
        expect(!UFQuickFind.connected(5, 0));
        expect(UFQuickFind.connected(5, 0));
        expect(UFQuickFind.connected(6, 0));
        expect(UFQuickFind.connected(1, 0));
        expect(UFQuickFind.count() == 2);
    }

}
