package array;

import java.util.*;

/**
 * 4Sum II
 * <p>
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 */
public class HardFourSumCount {
    public static void main(String[] args) {
        int[] a = {-1, -1};
        int[] b = {-1, 1};
        int[] c = {-1, 1};
        int[] d = {1, -1};
        System.out.println(fourSumCount(a, b, c, d));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> ABMap = new HashMap<>();
        int count = 0;
        for (int a : A) {
            for (int b : B) {
                ABMap.put(a + b, ABMap.getOrDefault(a + b, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                count += ABMap.getOrDefault(-c - d, 0);
            }
        }
        return count;
    }
}
