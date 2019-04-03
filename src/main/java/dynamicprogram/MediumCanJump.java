package dynamicprogram;

/**
 * Jump Game
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class MediumCanJump {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (max > i - 1) {
                max = Math.max(i + nums[i], max);
            } else {
                return false;
            }
        }
        return max >= nums.length - 1;
    }
}
