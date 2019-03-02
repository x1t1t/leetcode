package dynamicprogram;

/**
 * House Robber
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class EasyRob {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 3, 100};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len < 1) return 0;
        int max1 = 0, max2 = 0, i = 0, j = 1;
        while (i < len || j < len) {
            int t = j > 1 ? max2 - nums[j-2] : 0;
            if (j < len) {
                max2 = Math.max(max2 + nums[j], max1 + nums[j]);
                j += 2;
            }
            if (i < len) {
                max1 = Math.max(t + nums[i], max1 + nums[i]);
                i += 2;
            }
        }
        return Math.max(max1, max2);
    }
}
