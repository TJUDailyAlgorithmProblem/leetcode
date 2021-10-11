package 高级数据结构与算法作业._0918.homework;

import java.math.BigInteger;
import java.util.Scanner;

public class problemE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger ans = BigInteger.valueOf(1);
        BigInteger four = BigInteger.valueOf(4);
        BigInteger one = BigInteger.valueOf(1);
        BigInteger two = BigInteger.valueOf(2);
        for (int i = 2; i <= n; i++) {
            BigInteger bi = BigInteger.valueOf(i);
            ans = ans.multiply(four.multiply(bi).subtract(two)).divide(bi.add(one));
        }
        System.out.println(ans.toString());
    }
}