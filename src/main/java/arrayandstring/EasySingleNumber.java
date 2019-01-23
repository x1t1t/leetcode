package arrayandstring;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class EasySingleNumber {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int k = nums[0];
        for (int i = 1; i < nums.length; i++) {
            k ^= nums[i];
        }
        return k;
    }
}
