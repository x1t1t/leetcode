package dynamicprogram;


/**
 * Longest Increasing Subsequence
 * <p>
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class MediumLengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length < 2) return nums.length;
        /**ideaI o(n^2)
        int[] minCount = new int[nums.length];
        minCount[0] = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            int m = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    m = Math.max(m, 1 + minCount[j]);
                }
            }
            minCount[i] = m;
            max = Math.max(m, max);
        }
        return 1 + max;*/
        int[] record = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int i = 0, j = size;
            while (i != j) {
                int mid = (i + j) / 2;
                if (record[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            record[i] = num;
            if (i == size) size++;
        }
        return size;
    }
}
