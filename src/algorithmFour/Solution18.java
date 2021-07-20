package algorithmFour;

import common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuzhengshu
 * @description: 61. 旋转链表
 * @date 2021/7/20 10:58
 */
public class Solution18 {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        k = k % size;

        Integer[] nums1 = list.toArray(new Integer[0]);
        Integer[] nums2 = new Integer[k];
        Integer[] nums3 = new Integer[size - k];
        System.arraycopy(nums1, 0, nums3, 0, nums3.length);
        System.arraycopy(nums1, size - k, nums2, 0, nums2.length);

        ListNode resLisNode = new ListNode(0);
        ListNode currentNode = resLisNode;
        for (Integer integer : nums2) {
            currentNode.next = new ListNode(integer);
            currentNode = currentNode.next;
        }
        for (Integer integer : nums3) {
            currentNode.next = new ListNode(integer);
            currentNode = currentNode.next;
        }
        return resLisNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{0, 1, 2});
        ListNode listNode1 = rotateRight(listNode, 4);
        System.out.println(Arrays.toString(listNode1.toArray()));
    }
}
