package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Q234_PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        List<Integer> list = new ArrayList<>();

        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        int i = 0, j = list.size() - 1;

        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        int[] elements = {1, 2, 2, 1};
        ListNode head = listNode.createListNode(elements);
        boolean palindrome = new Q234_PalindromeLinkedList().isPalindrome(head);
        System.out.println(palindrome);
    }

}
