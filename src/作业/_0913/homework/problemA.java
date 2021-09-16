package 作业._0913.homework;

import java.util.Scanner;

public class problemA {
    static int[] father;

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
        if (fx > fy)
            father[fx] = fy;
        else
            father[fy] = fx;
    }

    public static boolean connected(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        if (xx == yy) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            father = new int[100010];
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
            }
            boolean isOK = true; //无环
            int root = -1;
            while (sc.hasNext()) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (x == 0 && y == 0) break;
                if (x == -1 && y == -1) return;
                if (connected(x, y)) {//如果已经联通
                    isOK = false;  //有环
                } else {
                    union(x, y); //联通
                }
                root = find(x);
            }
            for (int i = 0; i < father.length; i++) {    //是否连通
                if (father[i] != i && find(i) != root) {
                    isOK = false; //有环
                    break;
                }
            }
            if (isOK) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
