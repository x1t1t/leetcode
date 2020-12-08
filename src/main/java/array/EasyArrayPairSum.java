package array;

import java.util.Arrays;

/**
 * 数组拆分 I
 * <p>
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 * 返回该 最大总和 。
 */
public class EasyArrayPairSum {

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0, i = 0;
        while (i < nums.length) {
            sum += nums[i++];
            i++;
        }
        return sum;
    }
}
