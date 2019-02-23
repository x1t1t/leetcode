package tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

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
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
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
}
