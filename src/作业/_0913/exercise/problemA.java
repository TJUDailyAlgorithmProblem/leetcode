package 作业._0913.exercise;

import java.util.Scanner;

public class problemA {
    final static int MAX = 1005;
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
            father[a] = father_b;
        }
    }

    public static void main(String[] args) {
        int n, m;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            n = scanner.nextInt();
            if (n == 0) {
                return;
            }
            init(n);
            m = scanner.nextInt();
            int a, b;
            for (int i = 0; i < m; i++) {
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
            System.out.println(count - 1);
        }
    }
}
