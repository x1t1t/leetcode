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

    /**ideaI
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
    } */

    /**
     * dieaII
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) continue; // element already exists, skip
                tempList.add(num);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
