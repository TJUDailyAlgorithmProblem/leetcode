package 贪心算法;

public class _134 {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int startIndex = 0;
            int sum = 0;
            int curSum = 0;
            for (int i = 0; i < gas.length; i++) {
                sum += gas[i] - cost[i];
                curSum += gas[i] - cost[i];
                if (curSum < 0) {
                    startIndex = (i + 1) % gas.length;
                    curSum = 0;
                }
            }
            if (sum < 0) return -1;
            return startIndex;
        }
    }
}
