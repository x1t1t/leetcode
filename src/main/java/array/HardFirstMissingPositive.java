package array;

import java.util.ArrayList;
import java.util.List;

/**
 * First Missing Positive
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 */
public class HardFirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {-1, 4, 2, 1, 9, 10};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        /**ideaI
        int len = nums.length, min = 1;
        if (nums.length < 1) return 1;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (!list.contains(num) && num > 0 && num <= len) {
                list.add(num);
            } else {
                len--;
            }
        }
        while (min <= list.size() + 1) {
            if (list.contains(min)) {
                min++;
            } else {
                return min;
            }
        }
        return min;*/

        /**ideaII*/
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
                i--;
            }
        }
        int s = 0;
        while (s < nums.length && nums[s] == s + 1) s++;
        return s + 1;
    }

    private static void swap(int[] nums, int s, int e) {
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }
}
