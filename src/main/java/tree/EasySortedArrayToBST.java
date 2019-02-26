package tree;

import java.util.Arrays;

public class EasySortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        System.out.println(TreeNode.printTreeNode(sortedArrayToBST(nums)));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) return null;
        TreeNode node = new TreeNode(nums[len / 2]);
        node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, len / 2));
        if (len / 2 + 1 < len) {
            node.right = sortedArrayToBST(Arrays.copyOfRange(nums, len / 2 + 1, len));
        }
        return node;
    }
}
