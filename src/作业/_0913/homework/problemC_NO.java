package 作业._0913.homework;


import java.util.*;

public class problemC_NO {

    static class villageDistant {
        int village_num1;
        int village_num2;
        int distant;

        public villageDistant(int village_num1, int village_num2, int distant) {
            this.village_num1 = village_num1;
            this.village_num2 = village_num2;
            this.distant = distant;
        }
    }

    static int ans = 0; //存放答案
    static int count = 0;
    static int l = 0;
    static int[] father = new int[1005];
    static ArrayList<villageDistant> villageDistantList = new ArrayList<>();
    static Comparator c = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            villageDistant x = (villageDistant) o1;
            villageDistant y = (villageDistant) o2;
            if (x.distant > y.distant) {
                return -1;
            }
            return 1;
        }
    };

    public static void init(int n) {
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
    }

    public static int find(int x) {
        while (x != father[x]) {
            x = father[x];
        }
        return x;
    }

    public static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            father[fx] = fy;
            count++;
            ans += l;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (true) {
            if (n == 0) {
                break;
            }
            init(n);
            for (int i = 0; i < n * (n - 1) / 2; i++) {
                villageDistant villageDistant = new villageDistant(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                villageDistantList.add(villageDistant);
            }
            villageDistantList.sort(c);
            for (int i = 0; i < n * (n - 1) / 2; i++) {
                if (count == n - 1) {
                    break;
                }
                l = villageDistantList.get(i).distant;
                union(villageDistantList.get(i).village_num1, villageDistantList.get(i).village_num2);
            }
            System.out.println(ans);
        }
    }
}
