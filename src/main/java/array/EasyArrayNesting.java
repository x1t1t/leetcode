package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Array Nesting
 * <p>
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到并返回最大的集合S，S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 * <p>
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/array-nesting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EasyArrayNesting {
    public static void main(String[] args) {
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.print(arrayNesting(nums));
    }

    public static int arrayNesting(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int maxi = 0;
            for (int j = i; nums[j] != -1; ) {
                maxi++;
                int k = j;
                j = nums[j];
                nums[k] = -1;
            }
            max = Math.max(maxi, max);
        }
        return max;
    }
}
