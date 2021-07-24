package algorithmFour;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuzhengshu
 * @description:
 * @date 2021/7/22 13:47
 */
public class Solution22 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList1(head.next);
            headNew.random = copyRandomList1(head.random);
        }
        return cachedNode.get(head);
    }

    public Node copyRandomList(Node head) {
        //key:原来的节点 value;现在的节点
        Map<Node, Node> map = new HashMap<>();
        Node res = new Node(0);
        Node current = res;
        //复制普通链表
        for (Node index = head; index != null; index = index.next) {
            Node temp = new Node(index.val);
            current.next = temp;
            current = temp;
            map.put(index, current);
        }
        //复制random
        for (Node index = res.next, orgIndex = head; index != null; index = index.next, orgIndex = orgIndex.next) {
            index.random = map.get(orgIndex.random);
        }
        return res.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node node = new Solution22().copyRandomList(node1);
    }
}
