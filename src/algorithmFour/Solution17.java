package algorithmFour;

import common.ListNode;

import java.util.Arrays;

/**
 * @author yuzhengshu
 * @description: 反转链表
 * @date 2021/7/20 10:42
 */
public class Solution17 {
    public static ListNode reverseList(ListNode head) {
        ListNode currentNode = head;
        ListNode res = null;
        while (currentNode != null) {
            ListNode listNode = new ListNode(currentNode.val);
            currentNode = currentNode.next;
            listNode.next = res;
            res = listNode;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createListNode(new int[]{1,2,3,4});
        ListNode listNode = reverseList(head);
        System.out.println(Arrays.toString(listNode.toArray()));
    }
}
