package Leetcode.commonAlgos;

public class UnionFind {
    private int count;
    private int[] id;

    public UnionFind(int N) {
        this.count = N;
        this.id = new int[N];

        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int getCount() {
        return this.count;
    }

    // Find the root of the tree which node p resides
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;  // Already connected

        id[pRoot] = qRoot;  // Connect the tree of pRoot to qRoot
        count--;
    }
}
