package LinkedList;

import java.util.HashMap;

public class Q141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        ListNode p = head;

        while (p != null) {
            if (hashMap.containsKey(p)) {
                return true;
            }

            hashMap.put(p, 1);
            p = p.next;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-4);
        ListNode l2 = new ListNode(0, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode head = new ListNode(3, l3);
        l1.next = l2;

        boolean res = new Q141_LinkedListCycle().hasCycle(head);
        System.out.println(res);
    }

}
