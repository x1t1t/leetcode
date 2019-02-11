package arrayandstring;

import java.util.Arrays;

/**
 * Rotate Array
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class EasyRotate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        rotate1(nums, 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        int t = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = t;
        rotate(nums, --k);
    }

    private static void rotate1(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private static void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int t = nums[e];
            nums[e] = nums[s];
            nums[s] = t;
            s++;
            e--;
        }
    }
}
