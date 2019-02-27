package sortandsearch;

import java.util.Arrays;

/**
 * Merge Sorted Array
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
public class EasyMerge {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        while (n > 0) {
            if (m <= 0) {
                nums1[k--] = nums2[--n];
            } else {
                nums1[k--] = nums1[m - 1] > nums2[n - 1] ? nums1[--m] : nums2[--n];
            }
        }
    }
}
