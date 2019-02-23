package tree;

/**
 * Maximum Depth of Binary Tree
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class EasyMaxDepth {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(3, 9, 20, null, null, 15, 7);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
