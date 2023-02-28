package LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 141.环形链表
 */
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

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> hashSet = new HashSet<>();
        ListNode p = head;

        while (p != null) {
            // 如果存在HashSet中存在重复的值则会返回false
            if (!hashSet.add(p)) {
                return true;
            }

            hashSet.add(p);
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
