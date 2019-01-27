package arrayandstring;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class EasyMoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int flag = 0, i = 0;
        for (; i + flag < nums.length; i++) {
            while (i + flag < nums.length && nums[i + flag] == 0) {
                flag++;
            }
            if (i + flag < nums.length) {
                nums[i] = nums[i + flag];
            }
        }
        while (flag > 0) {
            nums[nums.length - flag] = 0;
            flag--;
        }
    }
}
