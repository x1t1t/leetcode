package linklist;

/**
 * Palindrome Linked List
 * <p>
 * 请判断一个链表是否为回文链表。
 */
public class EasyIsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(ListNode.create(1, 1, 2, 1)));
    }

    public static boolean isPalindrome(ListNode head) {
        int len = -1;
        ListNode node = new ListNode(0);
        node.next = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        len /= 2;
        ListNode node1 = new ListNode(0);
        node1.next = head;
        while (len >= 0) {
            node1 = node1.next;
            len--;
        }
        node1 = reverseList(node1);
        while (node1 != null) {
            if (head.val != node1.val) return false;
            node1 = node1.next;
            head = head.next;
        }
        return true;
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