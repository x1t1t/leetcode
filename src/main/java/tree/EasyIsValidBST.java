package tree;

/**
 * Validate Binary Search Tree
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class EasyIsValidBST {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(10, 5, 15, null, null, 6, 20);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null) {
            TreeNode node = root.left;
            while (node.right != null) {
                node = node.right;
            }
            if (node.val >= root.val) return false;
        }
        if (root.right != null) {
            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            if (node.val <= root.val) return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
