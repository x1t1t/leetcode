package dynamicprogram;

import java.util.Arrays;

/**
 * 完全平方数
 * <p>
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 */
public class NumSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(200));
    }

    public static int numSquares(int n) {
        int[] ints = new int[n + 1];
        Arrays.fill(ints, Integer.MAX_VALUE);
        ints[0] = 0;
        int a = (int) (Math.sqrt(n) + 1);

        int[] initNum = new int[a];
        for (int i = 1; i < a; i++) {
            initNum[i] = i * i;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < a; j++) {
                if (i < initNum[j]) {
                    break;
                }
                ints[i] = Math.min(ints[i], ints[i - initNum[j]] + 1);
            }
        }
        return ints[n];
    }
}
