package algorithmThree;

import common.ListNode;

//剑指 Offer 24. 反转链表
public class Solution2 {
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode(head.val);
        ListNode another = head.next;
        while (another != null) {

            ListNode temp1 = new ListNode(another.val);
            temp1.next = root;
            root = temp1;

            another = another.next;;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4});
        ListNode listNode1 = ReverseList(listNode);
        System.out.println(listNode1);
        System.out.println(1);
    }
}
