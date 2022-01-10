package 栈.单调栈;

import java.util.Stack;

/**
 * Description:
 *
 * @author zwill
 * @date 2021/10/11 9:38
 */
public class _901 {
    class StockSpanner {
        Stack<Integer> prices, weights;

        public StockSpanner() {
            prices = new Stack();
            weights = new Stack();
        }

        public int next(int price) {
            int w = 1;
            while (!prices.isEmpty() && prices.peek() <= price) {
                prices.pop();
                w += weights.pop();
            }

            prices.push(price);
            weights.push(w);
            return w;
        }
    }
}
