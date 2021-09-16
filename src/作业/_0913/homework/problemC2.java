package 作业._0913.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class problemC2 {
    static class Pair implements Comparable<Pair> {
        int x, y, w;
        public Pair(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.w - pair.w;
        }
    }

    public static void init() {
        p = new int[N];
        road = new Pair[M];
        cnt = 0;
        for (int i = 0; i < N; i++) p[i] = i;
    }

    public static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 110, M = 25010, n, cnt;
    static int p[];
    static Pair road[];

    public static void main(String[] args) throws IOException {
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            init();
            for (int i = 0; i < n * (n - 1) >> 1; i++) {
                String s[] = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                road[i] = new Pair(a, b, c);
            }

            Arrays.sort(road, 0, n * (n - 1) >> 1);

            int res = 0;
            for (int i = 0; i < n * (n - 1) >> 1; i++) {
                int x = road[i].x;
                int y = road[i].y;
                double w = road[i].w;
                x = find(x);
                y = find(y);
                if (x != y) {
                    p[x] = y;
                    res += w;
                    cnt++;
                }
            }
            System.out.println(res);
        }
    }
}

