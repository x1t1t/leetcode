package array;

/**
 * Increasing Triplet Subsequence
 * <p>
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 */
public class MediumIncreasingTriplet {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= min) {
                min = n;
            } else if (n <= max) {
                max = n;
            } else {
                return true;
            }
        }
        return false;
    }
}
