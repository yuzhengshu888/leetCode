package algorithmOne;

import common.ListNode;

/**
 * @description: 21.合并两个有序链表
 * @Author: yuzhengshu
 * @Date: 2021年5月19日 16:13
 */
public class Solution1 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode listNode;
        if (l1.val < l2.val) {
            listNode = new ListNode(l1.val);
            listNode.next = mergeTwoLists(l1.next, l2);
        } else {
            listNode = new ListNode(l2.val);
            listNode.next = mergeTwoLists(l2.next, l1);
        }
        return listNode;
    }

    public static void main(String[] args) {
    }
}
