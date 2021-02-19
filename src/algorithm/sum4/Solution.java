package algorithm.sum4;

/**
 * @description:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: yuzhengshu
 * @Date: 2020/9/15 19:12
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return this.add(l1, l2, 0);
    }

    public ListNode add(ListNode l1, ListNode l2, int carry) {
        int newCarry = 0;
        int remainder = 0;
        int sum = carry;

        //l1,l2都为空
        if (l1 == null && l2 == null) {
            if (carry == 1) {
                return new ListNode(1);
            } else {
                return null;
            }
        }
        if (l1 != null && l2 != null) {
            sum += l1.val + l2.val;
        } else if (l1 == null) {
            sum += l2.val;
        } else {
            sum += l1.val;
        }
        if (sum != 0) {
            newCarry = sum >= 10 ? 1 : 0;
            remainder = sum % 10;
        }
        ListNode currentNode = new ListNode(remainder);
        //l1 为空
        if (l1 == null) {
            if (newCarry == 1) {
                ListNode nextNode = this.add(new ListNode(1), l2.next, 0);
                if (nextNode != null) {
                    currentNode.next = nextNode;
                }
            } else {
                l2.setVal(remainder);
                return l2;
            }

        }
        //l2 为空
        else if (l2 == null) {
            if (newCarry == 1) {
                ListNode nextNode = this.add(l1.next, new ListNode(1), 0);
                if (nextNode != null) {
                    currentNode.next = nextNode;
                }
            } else {
                l1.setVal(remainder);
                return l1;
            }
        }
        //l1,l2都不为空
        else {
            ListNode nextNode = this.add(l1.next, l2.next, newCarry);
            if (nextNode != null) {
                currentNode.next = nextNode;
            }
        }
        return currentNode;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.setNext(new ListNode(4));
//        l1.next.setNext(new ListNode(3));
//
//        ListNode l2 = new ListNode(5);
//        l2.setNext(new ListNode(6));
//        l2.next.setNext(new ListNode(4));

        ListNode l1 = new ListNode(9);
        l1.setNext(new ListNode(8));

        ListNode l2 = new ListNode(1);
        Solution s = new Solution();
        ListNode listNode = s.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}
