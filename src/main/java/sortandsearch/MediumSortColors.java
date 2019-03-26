package sortandsearch;

import java.util.Arrays;

/**
 * Sort Colors
 * <p>
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 */
public class MediumSortColors {
    public static void main(String[] args) {
        int[] nums ={2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        if (nums.length < 2) return;
        int i = 0, j = nums.length - 1;
        for (int k = 0; k <= j; k++) {
            if (nums[k] == 0) {
                exchange(nums, k, i);
                i++;
            }
            if (nums[k] == 2) {
                exchange(nums, k, j);
                j--;
                k--;
            }
        }
    }

    private static void exchange(int[] nums, int form, int to) {
        int temp = nums[form];
        nums[form] = nums[to];
        nums[to] = temp;
    }
}
