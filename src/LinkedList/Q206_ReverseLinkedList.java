package LinkedList;

public class Q206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        // 结点c为当前结点, p为当前结点的前一个结点
        ListNode c = head, p = null;

        while (c != null) {
            // 拿到当前结点的后一个结点
            ListNode n = c.next;
            // 将当前结点的后一个结点指向当前结点的前一个结点
            c.next = p;
            // 将一个结点指向当前结点
            p = c;
            // 将当前结点指向后一个结点
            c = n;
        }

        return p;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        int[] elements = {1, 2, 3, 4, 5};
        ListNode head = listNode.createListNode(elements);
        listNode.printListNode(head);
        System.out.println();

        ListNode reverseHead = new Q206_ReverseLinkedList().reverseList(head);
        listNode.printListNode(reverseHead);
    }

}
