package linklist;

/**
 * Reverse Linked List
 */
public class EasyReverseList {

    public static void main(String[] args) {
        System.out.println(ListNode.printListNode(reverseList(ListNode.create(1, 2, 3, 4, 5))));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode node = null;
        while (head != null) {
            ListNode node1 = head;
            head = head.next;
            node1.next = node;
            node = node1;
        }
        return node;
    }
}
