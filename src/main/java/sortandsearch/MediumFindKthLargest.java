package sortandsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Kth Largest Element in an Array
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class MediumFindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums,4));
    }

    public static int findKthLargest(int[] nums, int k) {
        /**ideaI
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                list.add(nums[i]);
            } else {
                adjustList(list, nums[i]);
            }
        }
        list.sort(Comparator.comparingInt(a -> a));
        return list.get(0);*/
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    private static void adjustList(List<Integer> list, int num) {
        list.sort(Comparator.comparingInt(a -> a));
        if (num > list.get(0)) {
            list.remove(0);
            list.add(num);
        }
    }

}
