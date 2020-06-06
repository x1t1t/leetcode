package tree;

/**
 * Lowest Common Ancestor of a Binary Tree
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class MediumLowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode p = root.left.left;
        TreeNode q = root.left.right.left;
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) {
            return root;
        } else if (l != null) {
            return l;
        } else {
            return r;
        }
    }
}
