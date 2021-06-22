package design;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 173. 二叉搜索树迭代器
 * @Author: yuzhengshu
 * @Date: 2021年6月22日 16:15
 */
public class BSTIteratorNew {
    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BSTIteratorNew(TreeNode root) {
        cur = root;
        stack = new LinkedList<>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }

    /**
     * 中序遍历,左,中,右
     */
    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] nums = {7, 3, 15, null, null, 9, 20};
        TreeNode treeNode = TreeNode.createTreeNode(nums);
        BSTIteratorNew bstIterator = new BSTIteratorNew(treeNode);
        int a1 = bstIterator.next();
        int a2 = bstIterator.next();
        boolean b1 = bstIterator.hasNext();
        int a3 = bstIterator.next();
        boolean b2 = bstIterator.hasNext();
        boolean b3 = bstIterator.hasNext();
        int a4 = bstIterator.next();
        boolean b4 = bstIterator.hasNext();
        System.out.println("...");
    }
}
