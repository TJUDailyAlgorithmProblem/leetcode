package 并查集;

import java.util.ArrayList;
import java.util.List;

public class _990 {
    class Solution {
        public boolean equationsPossible(String[] equations) {
            UnionFind uf = new UnionFind(501);
            List<int[]> list = new ArrayList<>();
            for (String equation : equations) {
                char[] item = equation.toCharArray();
                char a = item[0];
                char b = item[3];
                if (item[1] == '=') {
                    uf.union(a, b);
                } else {
                    int[] tmp = new int[]{a, b};
                    list.add(tmp);
                }
            }
            for (int[] ints : list) {
                if (uf.find(ints[0]) == uf.find(ints[1])) {
                    return false;
                }
            }
            return true;
        }
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int index1, int index2) {
            parent[find(index2)] = find(index1);
        }

        public int find(int index) {
            if (parent[index] != index) {
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
    }
}
