package 作业._0913.homework;

import java.util.Scanner;

public class problemB_No {
    final static int MAX = 10001;
    static int[] father = new int[MAX];
    static int[] in = new int[MAX];
    static int[] vis = new int[MAX];

    public static void init() {
        for (int i = 1; i < MAX; i++) {
            vis[i] = 0;
            father[i] = i;
            in[i] = 0;
        }
    }

    // 路径压缩
    public static int find(int x) {
        while (father[x] != x) {
            father[x] = father[father[x]];
            x = father[x];
        }
        return x;
    }

    public static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            father[fx] = fy;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, treeNum = 1;
        int root, counts;
        boolean flag;
        while (true) {
            a = sc.nextInt();
            b = sc.nextInt();
            if (a == -1 && b == -1) {
                break;
            }
            if (a == 0 && b == 0) { //空树
                System.out.println("Case " + treeNum + " is a tree.");
                treeNum++;
                continue;
            }
            init();
            vis[a] = 1;
            vis[b] = 1;
            in[b]++;
            union(a, b);
            while (true) {
                a = sc.nextInt();
                b = sc.nextInt();
                if (a == 0 && b == 0) { //空树
                    break;
                }
                vis[a] = 1;
                vis[b] = 1;
                in[b]++;
                union(a, b);
            }
            flag = true;
            root = 0;
            counts = 0;
            for (int i = 0; i < MAX; i++) {
                if (vis[i] != 0 && in[i] == 0)///根节点个数
                {
                    root++;
                }
                if (in[i] >= 2)///除根节点外，其他点入度需为1
                {
                    flag = false;
                }
                if (vis[i] != 0 && father[i] == i)///点在一个集合中
                {
                    counts++;
                }
            }
            if (root != 1 || counts > 1) {
                flag = false;
            }
            if (flag) {
                System.out.println("Case " + treeNum + " is a tree.");
                treeNum++;
            } else {
                System.out.println("Case " + treeNum + " is a tree.");
                treeNum++;
            }
        }
    }
}
