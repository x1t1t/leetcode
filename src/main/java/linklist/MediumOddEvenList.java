package linklist;

/**
 * Odd Even Linked List
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 */
public class MediumOddEvenList {
    public static void main(String[] args) {
        System.out.println(ListNode.printListNode(oddEvenList(ListNode.create(2,1,3,5,6,4,7))));
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode node1 = head.next;
        ListNode node2 = head.next;
        while (node2 != null && node2.next != null) {
            head.next = node2.next;
            head = head.next;
            node2.next = node2.next.next;
            node2 = node2.next;
        }
        head.next = node1;
        return node.next;
    }
}
