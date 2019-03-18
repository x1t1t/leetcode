package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Populating Next Right Pointers in Each Node
 * <p>
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class MediumConnect {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<Node> queue1 = new LinkedList<>();
            while (queue.peek() != null) {
                Node node = queue.poll();
                node.next = queue.peek();
                if (node.left != null) queue1.offer(node.left);
                if (node.right != null) queue1.offer(node.right);
            }
            queue = queue1;
        }
        return root;
    }
}

