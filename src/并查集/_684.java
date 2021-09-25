package 并查集;

public class _684 {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] leader = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            leader[i] = i;
        }
        for (int[] edge : edges) {
            int root1 = findLeader(edge[0], leader);
            int root2 = findLeader(edge[1], leader);
            if (root1 == root2) {
                return edge;
            } else {
                leader[root1] = root2;
            }
        }
        return new int[2];
    }

    public int findLeader(int x, int[] leader) {
        while (x != leader[x]) {
            x = leader[x];
        }
        return x;
    }
}
