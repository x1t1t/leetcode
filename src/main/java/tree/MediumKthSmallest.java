package tree;

import java.util.Stack;

/**
 * Kth Smallest Element in a BST
 * <p>
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 */
public class MediumKthSmallest {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(5, 3, 6, 2, 4, null, null, 1);
        System.out.println(kthSmallest(root, 3));
    }

    static int count = 0;
    static int res = -1;

    public static int kthSmallest(TreeNode root, int k) {
        /**
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        int res = 0;
        while (!stack.empty()) {
            node = stack.pop();
            k--;
            if (k == 0) res = node.val;
            if (null != node.right) {
                TreeNode node1 = node.right;
                while (node1 != null) {
                    stack.push(node1);
                    node1 = node1.left;
                }
            }
        }
        return res;*/

        /**ideaII*/
        inorder(root,k);
        return res;
    }

    private static void inorder(TreeNode root, int k) {
        if (root == null) return ;
        inorder(root.left, k);
        count++;
        if (count == k) res = root.val;
        inorder(root.right, k);
    }
}
