package LinkedList;

public class Q83_RemoveDuplicatesFromSortedList {

    /**
     * 使用一个指针对重复的值进行删除
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;

        // 判断链表是否为空
        while (p != null) {
            // 如果p指针指向的结点和下一个结点的值相同, 则删除下一个结点
            if (p.next != null && p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return head;
    }

    /**
     * 使用一快一慢两个指针删除重复的值
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;

        while (fast != null) {
            // 如果slow指向的值和fast指向的值不同
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }

            fast = fast.next;
        }

        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        int[] elements = {1, 1, 2, 3, 3};
        ListNode head = listNode.createListNode(elements);

        listNode.printListNode(head);
        System.out.println();

        ListNode newHead = new Q83_RemoveDuplicatesFromSortedList().deleteDuplicates2(head);
        listNode.printListNode(newHead);
    }

}
