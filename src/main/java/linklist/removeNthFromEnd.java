package linklist;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = ListNode.create(1, 2, 3, 4, 5);
        ListNode node = removeNthFromEnd(head, 1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }

        ListNode node = new ListNode(0);
        ListNode node1 = node, node2 = node;
        node.next = head;
        for (int i = 0; i < n + 1; i++) {
            node1 = node1.next;
        }
        while (node1 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        node2.next = node2.next.next;

        return node.next;
    }
}
