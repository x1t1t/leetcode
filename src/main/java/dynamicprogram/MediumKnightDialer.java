package dynamicprogram;

import java.util.*;

/**
 * 935. 骑士拨号器
 * <p>
 * 象棋骑士有一个独特的移动方式，它可以垂直移动两个方格，水平移动一个方格，或者水平移动两个方格，垂直移动一个方格(两者都形成一个 L 的形状)。
 * 我们有一个象棋骑士和一个电话垫，如下所示，骑士只能站在一个数字单元格上(即蓝色单元格)。
 * 给定一个整数 n，返回我们可以拨多少个长度为 n 的不同电话号码。
 * 你可以将骑士放置在任何数字单元格上，然后你应该执行 n - 1 次移动来获得长度为 n 的号码。所有的跳跃应该是有效的骑士跳跃。
 * 因为答案可能很大，所以输出答案模 10^9 + 7.
 */
public class MediumKnightDialer {

    static final int MOD = 1000000007;

    public int knightDialer(int n) {
        int[][] moves = {
                {4, 6},
                {6, 8},
                {7, 9},
                {4, 8},
                {3, 9, 0},
                {},
                {1, 7, 0},
                {2, 6},
                {1, 3},
                {2, 4}
        };
        int[][] d = new int[2][10];
        Arrays.fill(d[1], 1);
        for (int i = 2; i <= n; i++) {
            int x = i & 1;
            for (int j = 0; j < 10; j++) {
                d[x][j] = 0;
                for (int k : moves[j]) {
                    d[x][j] = (d[x][j] + d[x ^ 1][k]) % MOD;
                }
            }
        }
        int res = 0;
        for (int x : d[n % 2]) {
            res = (res + x) % MOD;
        }
        return res;
    }

}
