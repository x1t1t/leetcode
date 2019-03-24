package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets
 * <p>
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 */
public class MediumSubsets {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 1};
        for (List<Integer> list : subsets(nums)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        build(lists, new ArrayList<>(), 0, nums);
        return lists;
    }

    private static void build(List<List<Integer>> lists, List<Integer> list, int i, int[] nums) {
        if (list.size() > nums.length) {
            return;
        }
        lists.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            if (list.contains(nums[j])) {
                continue;
            }
            list.add(nums[j]);
            build(lists, list, j + 1, nums);
            list.remove(list.size() - 1);
        }
    }

    private static void exchange(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
