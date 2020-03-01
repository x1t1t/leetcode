package dynamicprogram;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Coin Change 2
 * <p>
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 */
public class MediumCoinChange2 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        long start = System.currentTimeMillis();
        System.out.println(change(5, coins));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static int change(int amount, int[] coins) {
        if (coins == null || amount < 0) {
            return 0;
        }
//        return coin(amount, coins.length - 1, coins);

        int[] record = new int[amount + 1];
        record[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                record[i] += record[i - coin];
            }
        }
        return record[amount];
    }

    // 超时
    public static int coin(int amount, int index, int[] coins) {
        if (index < 0) {
            return 0;
        }
        if (amount < coins[index]) {
            return coin(amount, index - 1, coins);
        } else if (amount == coins[index]) {
            return 1 + coin(amount, index - 1, coins);
        } else {
            int count = 0;
            for (int i = index; i >= 0; i--) {
                count += coin(amount - coins[i], i, coins);
            }
            return count;
        }
    }
}
