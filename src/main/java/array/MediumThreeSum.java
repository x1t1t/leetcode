package array;

import java.util.*;

/**
 * 3Sum
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 */
public class MediumThreeSum {
    public static void main(String[] args) {
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        for (List<Integer> list : threeSum(nums)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        /** ideaI
        for (int i = 0; i < nums.length - 2; i++) {
            List<List<Integer>> lists1 = twoSum(Arrays.copyOfRange(nums, i + 1, nums.length), -nums[i]);
            for (List<Integer> list : lists1) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(nums[i]);
                list1.addAll(list);
                if (!isContains(lists, list1)) {
                    lists.add(list1);
                }
            }
        }
        return lists; */

        /** ideaII */
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int s = i + 1, e = nums.length - 1;
                while (s < e) {
                    if (nums[s] + nums[e] == -nums[i]) {
                        List list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[s]);
                        list.add(nums[e]);
                        lists.add(list);
                        while (s < e && nums[s] == nums[s + 1]) s++;
                        while (s < e && nums[e] == nums[e - 1]) e--;
                        s++;
                        e--;
                    } else if (nums[s] + nums[e] < -nums[i]) {
                        s++;
                    } else {
                        e--;
                    }
                }
            }
        }
        return lists;
    }

    private static boolean isContains(List<List<Integer>> lists, List<Integer> list1) {
        for (List<Integer> list : lists) {
            if (list.get(0).equals(list1.get(0)) && list.get(1).equals(list1.get(1)) && list.get(2).equals(list1.get(2))) {
                return true;
            }
        }
        return false;
    }

    public static List<List<Integer>> twoSum(int[] nums, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                list.add(map.get(num));
                lists.add(list);
            } else {
                map.put(n - num, num);
            }
        }
        return lists;
    }
}
