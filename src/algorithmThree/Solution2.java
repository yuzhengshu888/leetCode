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
            ListNode temp = another.next;
            //root = new ListNode(another.val, root);
            ListNode temp1 = new ListNode(another.val);
            temp1.next = root;
            root = temp1;
            another = temp;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4});
        System.out.println(ReverseList(listNode));
        System.out.println(1);
    }
}
