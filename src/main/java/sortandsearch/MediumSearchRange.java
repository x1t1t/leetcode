package sortandsearch;

import java.util.Arrays;

/**
 * Search for a Range
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class MediumSearchRange {
    public static void main(String[] args) {
        int[] nums = {5};
        System.out.println(Arrays.toString(searchRange(nums, 5)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length < 1) return new int[]{-1, -1};
        int s = 0, e = nums.length - 1, r = 0;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] > target) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        r = s;
        s = 0;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        if (s == r) {
            if (nums[s] == target) {
                return new int[]{s, s};
            } else {
                return new int[]{-1, -1};
            }
        } else {
            if (nums[r] == target) {
                return new int[]{s, r};
            } else {
                return new int[]{s, r - 1};
            }
        }
    }
}
