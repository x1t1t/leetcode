package linklist;

public class MediumReverseBetween {

    public static void main(String[] args) {
        System.out.println(ListNode.printListNode(reverseBetween(ListNode.create(3, 5), 1, 2)));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int index = 1;
        ListNode reverseNode1 = new ListNode();
        reverseNode1.next = head;
        ListNode reverseNode = reverseNode1;
        while (index < left) {
            head = head.next;
            reverseNode1 = reverseNode1.next;
            index++;
        }
        ListNode node = null;
        while (index <= right) {
            ListNode node1 = head;
            head = head.next;
            node1.next = node;
            node = node1;
            index++;
        }
        reverseNode1.next = node;
        ListNode node2 = node;
        while (node2.next != null) {
            node2 = node2.next;
        }
        node2.next = head;
        return reverseNode.next;
    }
}
