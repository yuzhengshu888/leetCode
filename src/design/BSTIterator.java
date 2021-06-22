package design;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 173. 二叉搜索树迭代器
 * @Author: yuzhengshu
 * @Date: 2021年6月22日 15:08
 */
public class BSTIterator {
    List<Integer> list;
    int index = 0;

    public BSTIterator(TreeNode root) {
        list = dfs(root);
    }

    //一次遍历完,存到list里面去
    private List<Integer> dfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.addAll(dfs(root.left));
        res.add(root.val);
        res.addAll(dfs(root.right));
        return res;
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

    /**
     * 可以优化,每次next的时候再去迭代树,可以使用栈的数据结构
     */
    public int next() {
        Integer integer = list.get(index);
        index++;
        return integer;
    }

    public boolean hasNext() {
        return index < list.size();
    }

    public static void main(String[] args) {
        Integer[] nums = {7, 3, 15, null, null, 9, 20};
        TreeNode treeNode = TreeNode.createTreeNode(nums);
        BSTIterator bstIterator = new BSTIterator(treeNode);
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
