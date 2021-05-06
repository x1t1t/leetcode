package array;

/**
 * Find the Duplicate Number
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class HardFindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 6};
        int[] nums2 = {3, 4, 6};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        if ((l1 + l2) % 2 == 1) {
            return findKthNum(nums1, nums2, (l1 + l2) / 2 + 1);
        } else {
            return (findKthNum(nums1, nums2, (l1 + l2) / 2) + findKthNum(nums1, nums2, (l1 + l2) / 2 + 1)) / 2.0;
        }
    }

    public static int findKthNum(int[] nums1, int[] nums2, int k) {
        int l1 = nums1.length, l2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            if (index1 == l1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == l2) {
                return nums1[index1 + k - 1];
            }
            int mid = k / 2;
            int newIndex1 = Math.min(mid + index1, l1) - 1;
            int newIndex2 = Math.min(mid + index2, l2) - 1;
            if (nums1[newIndex1] > nums2[newIndex2]) {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            } else {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }
        }
    }
}
