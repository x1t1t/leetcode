package others;

/**
 * Missing Number
 * <p>
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class EasyMissingNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i=0; i<nums.length; i++) {
            n +=(i-nums[i]);
        }
        return n;
    }
}
