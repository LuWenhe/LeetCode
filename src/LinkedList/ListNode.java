package LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode createListNode(int[] elements) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        if (elements.length < 1) {
            return null;
        }

        for (int element : elements) {
            // 结点的next默认为null
            p.next = new ListNode(element);
            p = p.next;
        }

        return dummy.next;
    }

    public void printListNode(ListNode listNode) {
        if (listNode == null) {
            System.out.println("链表为空");
        }

        ListNode start = listNode;

        while (start != null) {
            System.out.print(start.val + " ");
            start = start.next;
        }
    }

}