package algorithmOne;

import common.ListNode;

import java.util.HashSet;

/**
 * @description: 160. 相交链表
 * @Author: yuzhengshu
 * @Date: 2021年6月4日 11:03
 */
public class Solution21 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodeSet = new HashSet<>();
        ListNode head1 = headA;
        ListNode head2 = headB;
        while (head1 != null) {
            nodeSet.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (nodeSet.contains(head2)) {
                return head2.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        // 将a,b连成一个链表
        // a+b | b+a
        //当指针相等时,就是节点相交的部分
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {1};
        ListNode headA = ListNode.createListNode(nums1);
        ListNode headB = ListNode.createListNode(nums2);
        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode);
    }
}
