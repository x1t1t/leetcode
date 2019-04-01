package sortandsearch;

/**
 * Search in Rotated Sorted Array
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class MediumSearch {
    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        System.out.println(search(nums, 5));
    }

    public static int search(int[] nums, int target) {
        if (nums.length < 1) return -1;
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if(nums[mid] == target) return mid;
            if ((nums[nums.length - 1] < target && nums[mid] > target) ||
                    (nums[nums.length - 1] < target && nums[mid] < nums[nums.length - 1]) ||
                    (nums[nums.length - 1] >= target && nums[nums.length - 1] > nums[mid] && nums[mid] > target)) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return nums[s] == target ? s : -1;
    }
}
