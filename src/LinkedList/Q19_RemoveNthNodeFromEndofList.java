package LinkedList;

/**
 * 19.删除链表的倒数第N个结点
 */
public class Q19_RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode p1 = head;

        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head;

        // 如果p1还没有移动到null结点
        if (p1 != null) {
            // 需要将p2移动到倒数第k+1个结点, 因此p1和p2都少移动一位
            while (p1.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }

            p2.next = p2.next.next;
            return head;
            // 如果p1已经移动到null结点, 说明删除的是第一个结点, 只需要返回head.next即可
        } else {
            return head.next;
        }
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;

        for (int i = 0; i < n + 1; i++) {
            p = p.next;
        }

        ListNode q = dummy;

        while (p != null) {
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        int[] elements = {1,2};
        ListNode start = listNode.createListNode(elements);
//        ListNode deletedStart = new Solution().removeNthFromEnd(start, 1);
        ListNode deletedStart = new Q19_RemoveNthNodeFromEndofList().removeNthFromEnd1(start, 2);
        listNode.printListNode(deletedStart);
    }

}
