package array;

public class MediumMaxProduct {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4, -1};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int max = nums[0], maxI = nums[0], minI = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int flag = maxI;
            maxI = Math.max(minI * nums[i], Math.max(maxI * nums[i], nums[i]));
            minI = Math.min(flag * nums[i], Math.min(minI * nums[i], nums[i]));
            max = Math.max(max, maxI);
        }
        return max;
    }
}
