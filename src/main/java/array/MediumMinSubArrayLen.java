package array;

/**
 * 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 */
public class MediumMinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 1) {
            return nums[0] >= s ? 1 : 0;
        }
        int index = -1, sum = 0, max = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                max = Math.min(max, i - index);
                index++;
                if (index == nums.length - 1) {
                    break;
                }
                sum -= nums[index];
            }
        }
        return max == Integer.MAX_VALUE ? 0 : max;
    }
}
