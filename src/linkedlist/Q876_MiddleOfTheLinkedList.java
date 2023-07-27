package linkedlist;

public class Q876_MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode p1 = head, p2 = head;

        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }

        return p2;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        int[] elements = {1, 2, 3, 4, 5};
        ListNode head = listNode.createListNode(elements);
        ListNode node = new Q876_MiddleOfTheLinkedList().middleNode(head);
        System.out.println(node.val);
    }

}
