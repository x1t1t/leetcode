package array;

/**
 * Best Time to Buy and Sell Stock II
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class EasyMaxProfit {

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 4, 5};
        int max = maxProfit(prices);
        System.out.println(max);
    }

    private static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max += prices[i] - prices[i - 1] > 0 ? prices[i] - prices[i - 1] : 0;
        }
        return max;
    }
}
