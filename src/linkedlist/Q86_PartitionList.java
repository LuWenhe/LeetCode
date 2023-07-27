package linkedlist;

/**
 * 86.分隔链表
 */
public class Q86_PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1), p1 = dummy;
        ListNode dummy2 = new ListNode(-2), p2 = dummy2;
        ListNode p = head;

        while (p != null) {
            // 如果p1指向的值小于x
            if (p.val < x) {
                p1.next = p;
                // 别忘了p1要向前移动一位
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }

            p = p.next;
        }

        // 因为p2后面还跟着链表,因此需要将后面链表断开
        p2.next = null;
        p1.next = dummy2.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        int[] elements = {1, 4, 3, 2, 5, 2};
        ListNode head = listNode.createListNode(elements);
        listNode.printListNode(head);
        ListNode newHead = new Q86_PartitionList().partition(head, 3);
        listNode.printListNode(newHead);
    }

}
