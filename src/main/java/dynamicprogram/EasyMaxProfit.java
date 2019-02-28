package dynamicprogram;

/**
 * Best Time to Buy and Sell Stock
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 */
public class EasyMaxProfit {
    public static void main(String[] args) {
        int[] prices = {0, 3, 8, 6, 8, 6, 6, 8, 2, 0, 2, 7};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int max = 0;

        /** ideaI
         for (int i = 1; i < len; i++) {
         for (int j = 0; j < i; j++) {
         max = Math.max(max, prices[i]-prices[j]);
         }
         }
         return max;
         */

        /**ideaII
         int t = 0;
         for (int i = 1; i < len; i++) {
         t = Math.max(0, t + prices[i] - prices[i - 1]);
         max = Math.max(t, max);
         }
         return max;
         */

        //ideaIII
        int t = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] > t) {
                max = Math.max(max, prices[i] - t);
            } else {
                t = prices[i];
            }
        }
        return max;


    }
}
