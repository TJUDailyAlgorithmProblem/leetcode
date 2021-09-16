package 作业;


import java.util.*;

public class Main {
    final static int MAX = 2010;
    static int[] f = new int[MAX];
    static int[] r = new int[MAX];
    static boolean flag;

    public static void init(int n) {
        for (int j = 1; j <= n; j++) {
            f[j] = j;
            r[j] = 0;
        }
    }

    public static int find(int x) {
        if (x == f[x]) return x;
        int t = find(f[x]);
        r[x] = (r[x] + r[f[x]]) % 2;
        f[x] = t;
        return t;
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa == fb) {
            if (r[a] == r[b]) {
                flag = false;
            }
            return;
        }
        f[fb] = fa;
        r[fb] = (r[a] + 1 - r[b] + 2) % 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            init(n);
            flag = true;
            for (int j = 1; j <= m; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (flag) {
                    union(a, b);
                }
            }
            if (i != 1) System.out.println();//注意换行
            System.out.println("Scenario #" + i + ":");
            if (flag) {
                System.out.println("No suspicious bugs found!");
            } else {
                System.out.println("Suspicious bugs found!");
            }
        }
    }
}
