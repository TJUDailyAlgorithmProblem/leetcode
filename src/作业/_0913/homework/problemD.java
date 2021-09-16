package 作业._0913.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problemD {
    public static int father[];

    public static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int dis(Point o) {
            int dx = x - o.x;
            int dy = y - o.y;
            return (dx * dx) + (dy * dy);
        }
    }

    private static void union(int f, int t) {
        int a = findParent(f);
        int b = findParent(t);
        if (a == b) return;
        if (a > b) {
            father[a] = b;
        } else {
            father[b] = a;
        }
    }

    private static int findParent(int f) {
        while (father[f] != f) {
            f = father[f];
        }
        return f;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        d *= d;
        father = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
        Point[] p = new Point[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        List<Integer> repaire = new ArrayList<Integer>();
        while (sc.hasNext()) {
            if ("O".equals(sc.next())) {
                int a = sc.nextInt();
                for (int v : repaire) {
                    if (p[a].dis(p[v]) <= d) {
                        union(a, v);
                    }
                }
                repaire.add(a);
            } else {
                System.out.println(findParent(sc.nextInt()) == findParent(sc.nextInt()) ? "SUCCESS" : "FAIL");
            }
        }
    }
}
