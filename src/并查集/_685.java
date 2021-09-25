package 并查集;

public class _685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int len = edges.length;
        int[] inDegree = new int[len + 1];
        for (int[] edge : edges) {
            inDegree[edge[1]]++; //入度初始化
        }
        for (int i = len - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                if (!findCircle(edges, len, i)) {
                    return edges[i];
                }
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 1) {
                if (!findCircle(edges, len, i)) {
                    return edges[i];
                }
            }
        }
        return new int[2];
    }

    public boolean findCircle(int[][] edges, int len, int removeIndex) {
        UnionFind uf = new UnionFind(len + 1);
        for (int i = 0; i < len; i++) {
            if (i == removeIndex) continue;
            if (!uf.union(edges[i][0], edges[i][1])) {
                return true;
            }
        }
        return false;
    }

    private class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean union(int x, int y) {
            int x_root = find(x);
            int y_root = find(y);
            if (x_root == y_root) {
                return false;
            }
            parent[x_root] = y_root;
            return true;
        }
    }
}


