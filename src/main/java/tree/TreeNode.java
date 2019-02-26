package tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    TreeNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public static TreeNode createTree(Integer... elements) {
        if (elements.length <= 0 || elements[0] == null)
            return null;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        int i = 0;
        TreeNode treeNode = new TreeNode(elements[i]);
        queue.offer(treeNode);
        while (i < elements.length) {
            if (queue.isEmpty()) {
                throw new IllegalArgumentException("illegal params");
            }
            TreeNode treeNode1 = queue.poll();
            if (++i < elements.length && elements[i] != null) {
                treeNode1.left = new TreeNode(elements[i]);
                queue.offer(treeNode1.left);
            }
            if (++i < elements.length && elements[i] != null) {
                treeNode1.right = new TreeNode(elements[i]);
                queue.offer(treeNode1.right);
            }
        }
        return treeNode;
    }

    public static String printTreeNode(TreeNode node) {
        List<String> list = new ArrayList();
        if (node == null) return "";
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(node);
        while (!queue.isEmpty()) {
            if (queue.peek() == null) {
                list.add(null);
                queue.poll();
            } else {
                TreeNode node1 = queue.poll();
                list.add(String.valueOf(node1.val));
                if (node1.left != null || node1.right != null) {
                    queue.offer(node1.left);
                    queue.offer(node1.right);
                }
            }
        }
        return list.get(list.size() - 1) == null ? list.subList(0, list.size() - 1).toString() : list.toString();
    }
}
