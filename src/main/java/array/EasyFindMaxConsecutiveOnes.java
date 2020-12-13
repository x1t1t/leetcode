package array;

/**
 * 最大连续1的个数
 * <p>
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 */
public class EasyFindMaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, l = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(i - l - 1, max);
                l = i;
            }
        }
        return Math.max(nums.length - 1 - l, max);
    }
}
