package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode createListNode(int[] elements) {
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

    void printListNode(ListNode listNode) {
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