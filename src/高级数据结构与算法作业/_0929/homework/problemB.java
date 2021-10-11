package 高级数据结构与算法作业._0929.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Description:
 *
 * @author zwill
 * @date 2021/9/30 19:10
 */

public class problemB {

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int dis(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    public static int ccw(Point a, Point b, Point c) {
        return (a.x * b.y + b.x * c.y + c.x * a.y) - (a.y * b.x + b.y * c.x + c.y * a.x);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Point[] arr = new Point[N];
        int minIndex = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(x, y);
            if (y < arr[minIndex].y || (y == arr[minIndex].y && x < arr[minIndex].x)) {
                minIndex = i;
            }
        }
        Point temp = arr[minIndex];
        arr[minIndex] = arr[0];
        arr[0] = temp;
        Point a = arr[0];
        Arrays.sort(arr, 1, N, new Comparator<Point>() {
            @Override
            public int compare(Point b, Point c) {
                int result = ccw(a, b, c);
                if (result > 0) {
                    return -1;
                } else if (result < 0) {
                    return 1;
                } else {
                    int d1 = dis(a, b);
                    int d2 = dis(a, c);
                    return d1 - d2;
                }
            }
        });

        LinkedList<Point> list = new LinkedList<Point>();
        list.push(a);
        for (int i = 1; i < N; i++) {
            Point b = arr[i];
            list.push(b);
            if (i == N - 1) {//已经是最后一个了，最后一个点肯定是凸点，不用进行ccw了
                break;
            }

            while (ccw(list.get(1), list.peek(), arr[i + 1]) <= 0) {
                list.pop();
                if (list.size() <= 2) {
                    break;
                }
            }
        }
        double sum = 0;
        list.push(a);
        for (int i = 0; i < list.size() - 1; i++) {
            Point p1 = list.get(i);
            Point p2 = list.get(i + 1);
            sum = sum + Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
        }
        sum += 2 * L * Math.PI;
        System.out.println(Math.round(sum));
        reader.close();
    }
}

