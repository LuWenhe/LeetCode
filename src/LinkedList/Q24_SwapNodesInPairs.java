package LinkedList;

/**
 * 24.两两交换链表中的节点
 */
public class Q24_SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        // current是当前结点, prior是当前结点的前一个结点
        ListNode current = head, prior = null, newHead = null;

        // 如果链表只有一个结点, 返回当前节点
        if (current != null && current.next == null) {
            return current;
        }

        while (current != null) {
            // 得到当前结点的下一个结点
            ListNode q = current.next;

            // 如果链表含有奇数个结点(3、5、7...)
            if (q == null) {
                return newHead;
            }

            current.next = q.next;
            q.next = current;

            // 在第一次遍历中, 得到交换后的链表的头结点
            if (current == head) {
                newHead = q;
            } else {
                // 将前一个结点指向交换后的结点
                prior.next = q;
            }

            // 在第一次交换后, current指针指向前一个结点, 使用指针prior来保存该结点
            prior = current;
            current = current.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        int[] elements = {1,2,3,4,5};
        ListNode head = listNode.createListNode(elements);
        ListNode swapHead = new Q24_SwapNodesInPairs().swapPairs(head);
        listNode.printListNode(swapHead);
    }

}
