package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MediumGenerateTrees {

    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(3);
        for (TreeNode treeNode : treeNodes) {
            System.out.println(TreeNode.printTreeNode(treeNode));
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTree(1, n);
    }

    public static List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTree(start, i - 1);
            List<TreeNode> rightTrees = generateTree(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
