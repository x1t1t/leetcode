package array;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Sliding Window Maximum
 * <p>
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口最大值。
 */
public class HardMaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {-7, -8, 7, 5, 7, 1, 6, 0};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 4)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < 1) return nums;
        /**ideaI
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        res[0] = map.lastKey();
        for (int i = k; i < nums.length; i++) {
            if (map.get(nums[i - k]) > 1) {
                map.put(nums[i - k], map.get(nums[i - k]) - 1);
            } else {
                map.remove(nums[i - k]);
            }
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            res[i - k + 1] = map.lastKey();
        }
        return res;*/
        int[] res = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE, partition = -1;
        for (int i = k - 1; i < nums.length; i++) {
            if (partition < i - k + 1) {
                max = Integer.MIN_VALUE;
                for (int j = 0; j < k; j++) {
                    if (nums[i - j] > max) {
                        partition = i - j;
                        max = nums[i - j];
                    }
                }
            } else {
                if (nums[i] > max) {
                    partition = i;
                    max = nums[i];
                }
            }
            res[i - k + 1] = max;
        }
        return res;
    }
}
