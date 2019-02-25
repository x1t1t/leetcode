package tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Binary Tree Level Order Traversal
 * <p>
 * 给定一个二叉树，返回其按层次遍历的节点值。（即逐层地，从左到右访问所有节点）。
 */
public class EasyLevelOrder {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createTree(3,9,20,null,null,15,7);
        for (List<Integer> list : levelOrder(node)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue queue1 = new LinkedList();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue1.offer(node.left);
                if (node.right != null) queue1.offer(node.right);
            }
            lists.add(list);
            queue = queue1;
        }
        return lists;
    }
}
