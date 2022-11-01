package LinkedList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Q23_MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        // 队头存放头结点最小的链表
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode head : lists) {
            if (head != null) {
                priorityQueue.add(head);
            }
        }

        while (!priorityQueue.isEmpty()) {
            // 将头结点最小的那个链表出队
            ListNode node = priorityQueue.poll();
            // 让p指向该链表
            p.next = node;

            // 如果node结点后还有结点
            if (node.next != null) {
                // 使p指向最小的结点, 然后让最小结点的后一个结点入队
                priorityQueue.add(node.next);
            }

            // p再向后移动一位
            p = p.next;
        }

        return dummy.next;
    }

    public void printListNode(ListNode listNode) {
        for (ListNode p = listNode; p != null; p = p.next) {
            System.out.print(p.val + " ");
        }
    }

    public void testPriorityQueue() {
        // 创建优先队列, 该队列的头是最小的元素, 虽然优先队列元素可能没有排序, 但是元素总是按排列顺序检索的
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 升序排列
                return o1 - o2;
            }
        });

        // 使用add方法
        priorityQueue.add(18);
        priorityQueue.add(98);
        priorityQueue.add(20);
        System.out.println(priorityQueue);

        // 使用offer方法
        priorityQueue.add(87);
        priorityQueue.add(10);

        System.out.println(priorityQueue);

        Iterator<Integer> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        // 使用peek方法访问队列的头部元素
        Integer peek = priorityQueue.peek();
        Integer peek1 = priorityQueue.peek();

        System.out.println(peek + " " + peek1);

        // 返回并删除队头的元素
        Integer poll = priorityQueue.poll();
        Integer poll1 = priorityQueue.poll();
        Integer poll2 = priorityQueue.poll();

        System.out.println(poll + " " + poll1 + " " + poll2);
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];

        ListNode l11 = new ListNode(5);
        ListNode l12 = new ListNode(4, l11);
        ListNode l13 = new ListNode(1, l12);

        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(3, l21);
        ListNode l23 = new ListNode(1, l22);

        ListNode l31 = new ListNode(6);
        ListNode l32 = new ListNode(2, l31);

        listNodes[0] = l32;
        listNodes[1] = l13;
        listNodes[2] = l23;

        Q23_MergekSortedLists solution = new Q23_MergekSortedLists();
        ListNode listNode = solution.mergeKLists(listNodes);
        solution.printListNode(listNode);
    }

}
