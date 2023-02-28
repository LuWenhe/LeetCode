package LinkedList;

/**
 * 24.删除链表中重复元素
 */
public class Q82_RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p = dummy;

        while (p.next != null && p.next.next != null) {
            // 如果p指向的下个结点和下下个结点的值相同
            if (p.next.val == p.next.next.val) {
                // 拿到p指向的下个结点的值, 根据该结点的值删除后面相同的结点
                int x = p.next.val;

                while (p.next != null) {
                    if (p.next.val == x) {
                        p.next = p.next.next;
                    } else {
                        break;
                    }
                }
            } else {
                p = p.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        int[] elements = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = listNode.createListNode(elements);
        listNode.printListNode(head);
        ListNode newHead = new Q82_RemoveDuplicatesFromSortedListII().deleteDuplicates(head);
        listNode.printListNode(newHead);
    }

}
