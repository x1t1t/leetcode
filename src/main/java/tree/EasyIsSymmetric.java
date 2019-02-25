package tree;

/**
 * Symmetric Tree
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class EasyIsSymmetric {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createTree(1,2,2,null,3,null,3);
        System.out.println(isSymmetric(node));
    }

    public static boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric1(root.left, root.right);
    }

    private static boolean isSymmetric1(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 != null && node1.val == node2.val) {
            return isSymmetric1(node1.left, node2.right) && isSymmetric1(node1.right, node2.left);
        } else return false;
    }
}
