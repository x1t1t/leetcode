package dynamicprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Coin Change
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
public class MediumCoinChange {
    public static void main(String[] args) {
        int[] coins = {3, 7, 405, 436};
        System.out.println(coinChange(coins, 8839));
    }

    public static int coinChange(int[] coins, int amount) {
        if (coins.length < 1) return -1;
        int[] record = new int[amount];
        Arrays.sort(coins);
        return coin(coins, amount, record);
        /** 超时
         int[] record = new int[amount + 1];
         for (int n : coins) {
         if (n <= amount) {
         record[n] = 1;
         }
         }
         for (int i = 0; i < amount + 1; i++) {
         coin(coins, i, record);
         }
         return record[amount] == 0 ? -1 : record[amount];
         */

    }

    private static int coin(int[] coins, int amount, int[] record) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (record[amount - 1] != 0) return record[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int j = coins.length - 1; j >= 0; j--) {
            int c = coin(coins, amount - coins[j], record);
            if (c >= 0) {
                min = Math.min(1 + c, min);
            }
        }
        record[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return record[amount - 1];
    }
}
