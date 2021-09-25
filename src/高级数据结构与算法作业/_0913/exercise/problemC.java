package 高级数据结构与算法作业._0913.exercise;

import java.util.Scanner;
/*
题目描述：
* 严重急性呼吸系统综合症（SARS）是一种病因不明的非典型肺炎，在2003年3月中旬被认为是一种全球性的威胁。为了尽量减少对他人的传播，最好的策略是将嫌疑人与其他人分开。
在不传播疾病大学（NSYSU），有许多学生团体。同一小组的学生经常相互交流，一个学生可能加入几个小组。为了防止可能的SARS传播，NSYSU收集了所有学生团体的成员名单，并在其标准操作程序（SOP）中制定了以下规则。
一旦一个团体中的成员成为嫌疑人，该团体中的所有成员都是嫌疑人。
然而，他们发现，当一个学生被认定为嫌疑人时，要识别所有的嫌疑人并不容易。你的工作是编写一个程序，找到所有的嫌疑人。

输入：
输入包含几个案例。每个测试案例都以一行中的两个整数n和m开始，其中n是学生的数量，m是小组的数量。
你可以假设0 < n <= 30000，0 <= m <= 500。
每个学生都由0到n-1之间的唯一整数来编号，最初学生0被认定为所有情况下的嫌疑人。这一行的后面是m个组的成员名单，每组一行。每一行都以一个整数k开始，代表该组的成员数。在成员的数量之后，有k个整数代表这个小组的学生。一行中的所有整数之间至少有一个空格。
n=0和m=0的情况表示输入的结束，不需要处理。
* */


public class problemC {
    final static int MAX = 30001;
    static int[] father = new int[MAX];
    static int[] weights = new int[MAX];

    public static void init(int n) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
            weights[i] = 1;
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
        if (father_a == father_b) return;
        else {
            father[father_a] = father_b;
            weights[father_b] += weights[father_a];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        while (true) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            if (n == 0 && m == 0) break;
            init(n);
            int a, b, c;
            for (int i = 1; i <= m; i++) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                for (int j = 1; j < a; j++) {
                    c = scanner.nextInt();
                    union(b, c);
                }
            }
            System.out.println(weights[father[0]]);
        }
    }
}
