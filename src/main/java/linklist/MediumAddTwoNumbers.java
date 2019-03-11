package linklist;

/**
 * Add Two Numbers
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class MediumAddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = ListNode.create(5);
        ListNode l2 = ListNode.create(5);
        System.out.println(ListNode.printListNode(addTwoNumbers(l1, l2)));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = new ListNode(0);
        ListNode node = node1;
        int f = 0, sum = 0;
        while (l1 != null || l2 != null) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + f;
            node.next = new ListNode(sum % 10);
            f = sum / 10;
            node = node.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (f > 0) node.next = new ListNode(f);
        return node1.next;
    }
}
