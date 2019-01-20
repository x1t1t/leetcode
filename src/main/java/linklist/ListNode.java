package linklist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode create(int... elements) {
        ListNode head = new ListNode(0);
        ListNode node = new ListNode(0);
        head.next = node;
        for (int e : elements) {
            node.next = new ListNode(e);
            node = node.next;
        }
        return head.next.next;
    }
}
