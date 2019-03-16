package tree;

import java.util.*;

/**
 * Binary Tree Zigzag Level Order Traversal
 * <p>
 * 二叉树的锯齿形层次遍历
 */
public class MediumZigzagLevelOrder {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(3, 9, 20, null, null, 15, 7);
        for (List<Integer> list : zigzagLevelOrder(root)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int i = 0;
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue1 = new LinkedList();
            while (queue.peek() != null) {
                TreeNode node = queue.poll();
                if (i % 2 == 0) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                if (node.left != null) queue1.offer(node.left);
                if (node.right != null) queue1.offer(node.right);
            }
            i++;
            queue = queue1;
            lists.add(list);
        }
        return lists;
    }
}
