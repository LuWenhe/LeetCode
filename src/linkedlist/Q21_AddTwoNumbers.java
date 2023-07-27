package linkedlist;

/**
 * 21.合并两个有序链表
 */
public class Q21_AddTwoNumbers {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = list1, p2 = list2;

        while (p1 != null && p2 != null) {
            // 如果p1的值小于p2的值
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }

            // p需要向后移动一位
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }

    public void printListNode(ListNode listNode) {
        for (ListNode p = listNode; p != null; p = p.next) {
            System.out.println(p.val + " ");
        }
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(2, l11);
        ListNode start1 = new ListNode();

        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(3, l21);
        ListNode start2 = new ListNode(0);

        Q21_AddTwoNumbers solution = new Q21_AddTwoNumbers();
        ListNode res = solution.mergeTwoLists(start1, start2);
        solution.printListNode(res);
    }

}
