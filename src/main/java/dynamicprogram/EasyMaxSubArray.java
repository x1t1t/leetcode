package dynamicprogram;

/**
 * Maximum Subarray
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class EasyMaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, -1, -3, -4, -1, -2, -1, -5, -4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int max = nums[0], temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = Math.max(nums[i], temp + nums[i]);
            max = Math.max(max, temp);
        }
        return max;
    }
}
