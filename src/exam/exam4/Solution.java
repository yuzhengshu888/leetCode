package exam.exam4;

import common.ListNode;

public class Solution {
    public static ListNode merger(ListNode list1, ListNode list2) {
        ListNode root = new ListNode(1);
        ListNode currentNode = root;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currentNode.next = list1;
                currentNode = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                currentNode = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            currentNode.next = list1;
        }
        if (list2 != null) {
            currentNode.next = list2;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 3, 5, 7, 9});
        ListNode listNode1 = ListNode.createListNode(new int[]{2, 4, 5});
        ListNode merger = merger(listNode, listNode1);
        System.out.println("---");
    }
}
