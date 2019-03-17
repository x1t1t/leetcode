package tree;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * <p>
 * 从前序与中序遍历序列构造二叉树
 */
public class MediumBuildTree {
    public static void main(String[] args) {
        int[] preorder = {1,2,4,5,3,6,7};
        int[] inorder = {4,2,5,1,6,3,7};
        TreeNode node = buildTree(preorder, inorder);
        System.out.println(TreeNode.printTreeNode(node));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length || preorder.length < 1) return null;
        return buildTree(preorder, inorder, 0, 0, inorder.length);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int ps, int is, int ie) {
        int temp = preorder[ps];
        //point： 确定移动了几步找到相同的节点
        int i = 0;
        for (; i + is < ie; i++) {
            if (inorder[i + is] == temp) break;
        }
        TreeNode node = new TreeNode(temp);
        if (i + is > is) {
            node.left = buildTree(preorder, inorder, ps + 1, is, i + is);
        }
        if (i + is < ie - 1) {
            node.right = buildTree(preorder, inorder, ps + i + 1, i + is + 1, ie);
        }
        return node;
    }
}
