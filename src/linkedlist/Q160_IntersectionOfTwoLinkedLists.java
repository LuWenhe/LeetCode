package linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q160_IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        Set<ListNode> hashSet = new HashSet<>();

        while (p1 != null) {
            hashSet.add(p1);
            p1 = p1.next;
        }

        while (p2 != null) {
            if (hashSet.contains(p2)) {
                return p2;
            }

            p2 = p2.next;
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        ListNode p1 = headA, p2 = headB, head = null;

        while (p1 != null) {
            hashMap.put(p1, 1);
            p1 = p1.next;
        }

        while (p2 != null) {
            if (hashMap.getOrDefault(p2, -1) > 0) {
                head = p2;
                break;
            }

            p2 = p2.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        int[] elements = {8, 4, 5};
        ListNode commonHead = listNode.createListNode(elements);

        ListNode l1 = new ListNode(1, commonHead);
        ListNode l11 = new ListNode(4, l1);

        ListNode l2 = new ListNode(1, commonHead);
        ListNode l21 = new ListNode(6, l2);
        ListNode l22 = new ListNode(5, l21);

        listNode.printListNode(l11);
        listNode.printListNode(l22);

        ListNode intersectionNode = new Q160_IntersectionOfTwoLinkedLists().getIntersectionNode(l1, l2);
        System.out.println(intersectionNode.val);
    }

}
