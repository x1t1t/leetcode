package linklist;

/**
 * Intersection of Two Linked Lists
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class MediumGetIntersectionNode {
    public static void main(String[] args) {
        ListNode node = ListNode.create(8,4,5);
        ListNode headA = ListNode.create(4, 1);
        ListNode headB = ListNode.create(5, 0, 1);
        headA.next = node;
        headB.next = node;
        System.out.println(ListNode.printListNode(getIntersectionNode(headA, headB)));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /** ideaI
        ListNode node1 = headA;
        ListNode node2 = headB;
        int len1 = 0, len2 = 0;
        while (node1 != null) {
            len1++;
            node1 = node1.next;
        }
        while (node2 != null) {
            len2++;
            node2 = node2.next;
        }
        node1 = headA;
        node2 = headB;
        int i = Math.abs(len1 - len2);
        if (len1 > len2) {
            while (i > 0) {
                node1 = node1.next;
                i--;
            }
        } else if (len1 < len2) {
            while (i > 0) {
                node2 = node2.next;
                i--;
            }
        }
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;*/

        /**ideaII*/
        if (headA == null || headB == null) return null;
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = null == node1 ? headB : node1.next;
            node2 = null == node2 ? headA : node2.next;
        }
        return node1;
    }
}
