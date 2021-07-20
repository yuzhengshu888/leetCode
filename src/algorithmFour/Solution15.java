package algorithmFour;

import common.ListNode;

/**
 * @author yuzhengshu
 * @description: 23. 合并K个升序链表
 * @date 2021/7/19 15:45
 */
public class Solution15 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        ListNode mergeLeft = merge(lists, left, mid);
        ListNode mergeRight = merge(lists, mid + 1, right);
        return mergeTwoLists(mergeLeft, mergeRight);
    }

    public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        ListNode asnListNode = new ListNode(0);
        ListNode currentNode = asnListNode;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                currentNode.next = new ListNode(listNode1.val);
                listNode1 = listNode1.next;
            } else {
                currentNode.next = new ListNode(listNode2.val);
                listNode2 = listNode2.next;
            }
            currentNode = currentNode.next;
        }
        if (listNode1 == null) {
            currentNode.next = listNode2;
        }
        if (listNode2 == null) {
            currentNode.next = listNode1;
        }
        return asnListNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.createListNode(new int[]{1, 4, 5});
        ListNode listNode2 = ListNode.createListNode(new int[]{1, 3, 4});
        ListNode listNode3 = ListNode.createListNode(new int[]{2, 6});
        new Solution15().mergeKLists(new ListNode[]{listNode1, listNode2, listNode3});
    }
}
