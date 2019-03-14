package tree;

import java.util.*;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 */
public class MediumInorderTraversal {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(inorderTraversal(TreeNode.createTree(1, null, 2, 3)).toArray()));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        /** ideaI
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        if (!inorderTraversal(root.left).isEmpty()) {
            list.addAll(inorderTraversal(root.left));
        }
        list.add(root.val);
        if (!inorderTraversal(root.right).isEmpty()) {
            list.addAll(inorderTraversal(root.right));
        }
        return list;*/

        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        while (node!=null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.empty()) {
            node = stack.pop();
            list.add(node.val);
            if (null != node.right) {
                TreeNode node1 = node.right;
                while (node1 != null) {
                    stack.push(node1);
                    node1 = node1.left;
                }
            }
        }
        return list;
    }
}
