//package 并查集;
//
//import java.util.Arrays;
//
//public class _1697 {
//    class Solution {
//        //        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
////            int queriesLen = queries.length;
////            int edgesLen = edgeList.length;
////            boolean[] res = new boolean[queriesLen];
////            UnionFind uf = new UnionFind(n);
////            Index2Query[] index2Queries = new Index2Query[queriesLen];
////
////            // 初始化query与原始顺序之间的关系
////            for (int i = 0; i < queriesLen; i++) {
////                index2Queries[i] = new Index2Query(queries[i], i);
////            }
////
////            // 将queries 和 edgeList 分别按照边权长度排序。
////            Arrays.sort(edgeList, (e1, e2) -> e1[2] - e2[2]);
////            Arrays.sort(index2Queries, (q1, q2) -> q1.query[2] - q2.query[2]);
////            //
////            int i = 0;
////            for (int j = 0; j < queriesLen; j++) {
////                int x = index2Queries[j].query[0];
////                int y = index2Queries[j].query[1];
////                int l = index2Queries[j].query[2];
////                // 在访问query时，将边长小于l的edges先加入并查集
////                while (i < edgesLen && edgeList[i][2] < l) {
////                    uf.union(edgeList[i][0], edgeList[i][1]);
////                    ++i;
////                }
////                // 在判断时，比l小的边已经全部加入并查集
////                if (uf.isConnected(x, y)) {
////                    res[index2Queries[j].index] = true;
////                }
////            }
////            return res;
////        }
//        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
//            int edgesNum = edgeList.length;
//            int queriesNum = queries.length;
//            UnionFind unionFind = new UnionFind(n);
//            boolean[] res = new boolean[queriesNum];
//            Index2Query[] index2Queries = new Index2Query[queriesNum];
//            for (int i = 0; i < queriesNum; i++) {
//                index2Queries[i] = new Index2Query(queries[i], i);
//            }
//            Arrays.sort(edgeList, (e1, e2) -> e1[2] - e2[2]);
//            Arrays.sort(index2Queries, (q1, q2) -> q1.query[2] - q2.query[2]);
//            int i = 0;
//            for (int j = 0; j < queriesNum; j++) {
//
//            }
//        }
//    }
//
//    // 因为query在排序后会改变顺序，需要记录下原始索引用于以原来的顺序输出查询结果
//    class Index2Query {
//        public int[] query;
//        public int index;
//
//        public Index2Query(int[] query, int index) {
//            this.index = index;
//            this.query = query;
//        }
//    }
//
//    // 并查集
//    class UnionFind {
//        private int[] parent;
//
//        public UnionFind(int n) {
//            parent = new int[n];
//            for (int i = 0; i < n; i++) {
//                parent[i] = i;
//            }
//        }
//
//        public int find(int i) {
//            if (parent[i] != i) {
//                parent[i] = find(parent[i]);
//                return parent[i];
//            }
//            return i;
//        }
//
//        public void union(int x, int y) {
//            int rootX = find(x);
//            int rootY = find(y);
//            parent[rootX] = rootY;
//        }
//
//        public boolean isConnected(int x, int y) {
//            int rootX = find(x);
//            int rootY = find(y);
//            return rootX == rootY;
//        }
//    }
//}
