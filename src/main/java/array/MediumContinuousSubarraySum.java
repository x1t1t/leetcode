package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Continuous Subarray Sum
 * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [23,2,4,6,7], k = 6
 * 输出: True
 * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
 */
public class MediumContinuousSubarraySum {

    public static void main(String[] args) {
        int[] nums = {0,0};
        System.out.print(checkSubarraySum(nums, 0));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
//        for (int i = 0; i < nums.length - 1; i++) {
//            long sum = nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                sum += nums[j];
//                if ((k != 0 && sum % k == 0) || (k == 0) && sum == 0) {
//                    return true;
//                }
//            }
//        }
//        return false;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum;
            if (k != 0) {
                mod = sum % k;
            }
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }
}
