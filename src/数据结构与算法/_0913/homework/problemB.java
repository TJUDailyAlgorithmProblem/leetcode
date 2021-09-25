package 数据结构与算法._0913.homework;

import java.util.Arrays;
import java.util.Scanner;

public class problemB {
    public static int[] father = new int[1000];

    public static int find(int x) {
        int r = x;
        while (father[r] != r) r = father[r];
        return r;
    }

    public static boolean join(int x, int y) {
        int dx = find(x);
        int dy = find(y);
        if (dy != y) {       //这个主要判断一个节点不能有两个前驱节点
            return true;
        }
        if (dx != dy) {
            father[dy] = dx;
            return false;
        }
        return true;   //有环
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c = 1;
        boolean flag = false;
        while (true) {
            a = sc.nextInt();
            b = sc.nextInt();
            if (a < 0 && b < 0)     //输入两个负数结束
                return;
            if (a == 0 && b == 0) {
                int sum = 0;
                int tmp = -1;
                for (int i = 1; i < 1000; i++) {
                    if (father[i] == i) sum++;   //判断是否有森林
                    if (father[i] != 0) {        //这个判断是否只有一个根节点
                        if (tmp == -1)
                            tmp = find(i);
                        if (tmp != find(i))
                            flag = true;
                    }
                }
                if (sum > 1 || flag)
                    System.out.println("Case " + c + " is not a tree.");
                else
                    System.out.println("Case " + c + " is a tree.");

                flag = false;
                Arrays.fill(father, 0);
                c++;
                continue;
            }
            if (father[a] == 0) father[a] = a;
            if (father[b] == 0) father[b] = b;
            if (join(a, b))   //join返回true，说明有环或者一个节点有超过一个前驱节点
                flag = true;
        }
    }
}
