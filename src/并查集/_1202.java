package 并查集;


import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class _1202 {

    class Solution {
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            int len = s.length();
            UnionFind uf = new UnionFind(len);
            for (List<Integer> pair : pairs) {
                uf.union(pair.get(0), pair.get(1));
            }
            HashMap<Integer, PriorityQueue<Character>> hashMap = new HashMap<>();
            for (int i = 0; i < len; i++) {
                int cur = uf.find(i);
                if (!hashMap.containsKey(cur)) {
                    hashMap.put(cur, new PriorityQueue<>());
                }
                hashMap.get(cur).offer(s.charAt(i));
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append(hashMap.get(uf.find(i)).poll());
            }
            return sb.toString();
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
}