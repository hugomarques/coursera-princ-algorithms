/**
 * Quick find algorithm that describes if 2 ids are connected.
 * union O(N)
 * find O(1)
 */
public class UFQuickFind {

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
    public UFQuickFind(final int n) {
        this.n = n;
        this.groups = n;
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    /**
     * Connect 2 elements to be part of the same group.
     * @param pId First element.
     * @param qId Second element.
     */
    public void union(final int pId, final int qId) {
        int pGroup = ids[pId];
        int qGroup = ids[qId];
        if (pGroup != qGroup) {
            for (int i = 0; i < this.n; i++) {
                if (ids[i] == pGroup) {
                    ids[i] = qGroup;
                }
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
        return ids[p];
    }

    /**
     * Determines if 2 elements are part of the same group.
     * @param p id for first element.
     * @param q id for second element.
     * @return true if they have the same id, false otherwise.
     */
    public boolean connected(final int p, final int q) {
        return ids[p] == ids[q];
    }

    /**
     * Number of different groups existing on this data structure.
     * @return
     */
    public int count() {
        return this.groups;
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
        final UFQuickFind UFQuickFind = new UFQuickFind(10);
        UFQuickFind.union(4, 3);
        UFQuickFind.union(3, 8);
        UFQuickFind.union(6, 5);
        UFQuickFind.union(9, 4);
        UFQuickFind.union(2, 1);
        expect(true == UFQuickFind.connected(8, 9));
        expect(false == UFQuickFind.connected(5, 0));

        UFQuickFind.union(5, 0);
        UFQuickFind.union(7, 2);
        UFQuickFind.union(6, 1);
        expect(true == UFQuickFind.connected(5, 0));
        expect(UFQuickFind.count() == 2);
    }

}
