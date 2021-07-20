package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2020/9/15 19:12
 */
public class ListNode {
    public int val;
    public ListNode next;

    public static ListNode createListNode(int[] s) {
        if (s.length == 0) {
            return null;
        }
        ListNode root = new ListNode(s[0]);
        ListNode other = root;
        for (int i = 1; i < s.length; i++) {
            ListNode temp = new ListNode(s[i]);
            other.setNext(temp);
            other = temp;
        }
        return root;
    }

    public Integer[] toArray() {
        ListNode listNode = this;
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list.toArray(new Integer[0]);
    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
