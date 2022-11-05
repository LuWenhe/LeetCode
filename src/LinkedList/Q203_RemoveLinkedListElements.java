package LinkedList;

/**
 * 移除链表元素
 */
public class Q203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        // 设置虚拟结点
        ListNode dummy = new ListNode(-1);
        // 指针p用来删除结点
        ListNode p = dummy;

        dummy.next = head;

        while (p != null) {
            // 如果pre指向的下一个结点的值等于val, 则删除下一个结点
            if (p.next != null && p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        int[] elements = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = listNode.createListNode(elements);
        ListNode newHead = new Q203_RemoveLinkedListElements().removeElements(head, 6);
        listNode.printListNode(newHead);
    }

}
