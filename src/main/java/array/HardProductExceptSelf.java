package array;

/**
 * Product of Array Except Self
 * <p>
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 */
public class HardProductExceptSelf {
    public static void main(String[] args) {

    }

    public static int[] productExceptSelf(int[] nums) {
        int product = 1, zeroCount = 0;
        int[] result = new int[nums.length];
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
            product *= (num == 0 ? 1 : num);
        }
        if (zeroCount >= 2) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 0) {
                result[i] = product / nums[i];
            } else {
                if (nums[i] == 0) {
                    result[i] = product;
                } else {
                    result[i] = 0;
                }
            }

        }
        return result;
    }
}
