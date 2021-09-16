package 作业._0913.homework;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;

import java.util.Scanner;

/*
* 大致题意：
解释一下第一个样例吧:
3,3表示3个数(1,2,3)，接下来3行表示每两个数之间的关系；
1 2表示1,2是恋爱关系（就当成这个意思理解吧）；
2 3表示2,3是恋爱关系；
1 3表示1,3是恋爱关系；
所以这3个人中存在同性恋，输出“Suspicious bugs found!”；
对于不存在同性恋的情况输出“No suspicious bugs found!”；
现在，题目就是要求我们判断是否存在同性恋。

解题思路：
分组并查集（种类并查集）。我们可以这样思考a b存在恋爱关系，表示他们是异性，之间相互矛盾，用集合A表示与a是相同性别
的元素，集合B表示与a是不同性别的元素，这样的话a放在A集合，a+n（表示与a相异的性别）放在B集合,b放在B集合，b+n放在
A集合。如果在统计时发现，a和a+n或是b和b+n在相同的集合里面就是出现了矛盾的情况，即存在同性恋，反之，不存在。
* */
public class problemE {
    final static int MAXN = 3000;
    static int[] f = new int[MAXN];
    static int[] r = new int[MAXN];
    static boolean flag;

    public static int getf(int x) {
        if (x == f[x]) return x;
        int t = getf(f[x]);
        r[x] = (r[x] + r[f[x]]) % 2;
        f[x] = t;
        return t;
    }

    public static void Union(int a, int b) {
        int fa = getf(a);
        int fb = getf(b);
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
            for (int j = 1; j <= n; j++) {
                f[i] = i;
                r[i] = i;
            }
            flag = true;
            for (int j = 0; j < m; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (flag) {
                    Union(a, b);
                }
            }
            System.out.println("Scenario #" + i + ":");
            if (flag) {
                System.out.println("No suspicious bugs found!");
            } else {
                System.out.println("Suspicious bugs found!");
            }
        }
    }
}
