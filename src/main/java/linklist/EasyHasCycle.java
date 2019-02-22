package linklist;

/**
 * Linked List Cycle
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class EasyHasCycle {
    public static void main(String[] args) {
        ListNode node = ListNode.create(3);
        ListNode node1 = ListNode.create(2);
        ListNode node2 = ListNode.create(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node1;
        System.out.println(hasCycle(node));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
