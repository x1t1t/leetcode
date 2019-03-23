package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Permutations
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class MediumPermute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        for (List<Integer> list : permute(nums)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        build(lists, list, 0, nums);
        return lists;
    }

    private static void build(List<List<Integer>> lists, List<Integer> list, int i, int[] nums) {
        if (list.size() == nums.length) {
            lists.add(list);
            return;
        }

        for (int j = i; j < nums.length; j++) {
            List<Integer> list1 = new ArrayList<>(list);
            list1.add(nums[j]);
            exchange(nums, i, j);
            build(lists, list1, ++i, nums);
            exchange(nums, --i, j);
        }
    }

    private static void exchange(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
