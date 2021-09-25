package 高级数据结构与算法作业._0913.exercise;

import java.util.Scanner;

/*
* 题目意思：在T组输入输出的情况下，有n个人参加生日聚会，有m种关系，问最后需要多少个桌子。
解题思路：并查集的基本应用，在这里是将参加聚会的n个人按照关系分为几种集合，有几种集合就需要几个桌子。
* */
public class problemB {
    final static int MAX = 1001;
    static int[] father = new int[MAX];

    public static void init(int n) {
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
    }

    public static int find(int x) {
        if (x != father[x]) {
            return find(father[x]);
        }
        return x;
    }

    public static void union(int a, int b) {
        int father_a = find(a);
        int father_b = find(b);
        if (father_a != father_b) {
            father[father_a] = father_b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        int n, m;
        while (times-- != 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            init(n);
            int a, b;
            for (int i = 1; i <= m; i++) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                union(a, b);
            }
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (father[i] == i) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
