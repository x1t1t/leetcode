package linklist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode() {};

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

    public static String printListNode(ListNode node) {
        StringBuilder out = new StringBuilder();
        while (node != null) {
            out.append(node.val);
            node = node.next;
            if (node != null) {
                out.append(" -> ");
            }
        }
        return out.toString();
    }
}
