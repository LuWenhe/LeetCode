package linkedlist;

public class Q2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义一个虚拟结点
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        // 定义进位的数, 如果两个值加起来大于等于10, 进位为1
        int carry = 0;

        // 只要l1和l2指针有一个不指向null
        while(l1 != null || l2 != null) {
            // 如果l1指向null, 赋值为0, 如果l1指向不为null, 拿到当前结点的值
            int x = l1 == null ? 0 : l1.val;
            // 如果l2指向null, 赋值为0, 如果l2指向不为null, 拿到当前结点的值
            int y = l2 == null ? 0 : l2.val;
            // 将两个结点的值和进位的值相加
            int sum = x + y + carry;

            // 得到进位的值
            carry = sum / 10;
            // 如果和大于10, 则取模
            sum = sum % 10;
            // 将得到的值初始化为一个链表的结点
            cur.next = new ListNode(sum);
            cur = cur.next;

            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }

        // 如果加到最后一位还是有进位1, 则需要添加一个结点
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return pre.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        int[] num1 = {9, 9, 9};
        int[] num2 = {9};

        ListNode l1 = listNode.createListNode(num1);
        ListNode l2 = listNode.createListNode(num2);

        ListNode addNum = new Q2_AddTwoNumbers().addTwoNumbers(l1, l2);
        listNode.printListNode(addNum);
    }

}
