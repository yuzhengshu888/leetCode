package algorithmOne;

import common.ListNode;

//203. 移除链表元素
public class Solution22 {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode resNode = new ListNode(0);
        ListNode tempNode = resNode;
        while (head != null) {
            if (head.val != val) {
                ListNode temp = new ListNode(head.val);
                tempNode.next = head;
                tempNode = temp;
            }
            head = head.next;
        }
        return resNode.next;
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = ListNode.createListNode(nums);
        ListNode listNode = removeElements(head, 6);
        System.out.println(listNode);
    }
}
