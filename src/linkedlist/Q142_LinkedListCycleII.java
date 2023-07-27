package linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 142.环形链表II
 */
public class Q142_LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        ListNode p = head;

        while (p != null) {
            if (hashMap.containsKey(p)) {
                return p;
            }

            hashMap.put(p, 1);
            p = p.next;
        }

        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;

        while (p != null) {
            if (!set.add(p)) {
                return p;
            }

            set.add(p);
            p = p.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-4);
        ListNode l2 = new ListNode(0, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode head = new ListNode(3, l3);
        l1.next = l3;

        ListNode listNode = new Q142_LinkedListCycleII().detectCycle2(head);
        System.out.println(listNode.val);
    }

}
