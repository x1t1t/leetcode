package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Longest Consecutive Sequence
 * <p>
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 */
public class HardLongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        /**ideaI
        if (nums.length < 2) return nums.length;
        Arrays.sort(nums);
        int max = 0, flag = 0, value = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] || nums[i] == nums[i - 1] + 1) {
                flag = nums[i] - value + 1;
            } else {
                value = nums[i];
            }
            max = Math.max(max, flag);
        }
        return max;*/
        /**ideaII*/
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
//                int left = map.getOrDefault(num - 1, 0);
//                int right = map.getOrDefault(num + 1, 0);
                int left = map.containsKey(num-1)?map.get(num-1):0;
                int right = map.containsKey(num+1)?map.get(num+1):0;
                int sum = left + right + 1;
                max = Math.max(max, sum);
                map.put(num, sum);
                map.put(num - left, sum);
                map.put(num + right, sum);
            }
        }
        Arrays.sort(nums);
        return max;
    }
}
