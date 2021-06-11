package algorithmOne;

import common.TreeNode;

import java.util.*;

/**
 * @description: 144. 二叉树的前序遍历
 * @Author: yuzhengshu
 * @Date: 2021年6月11日 14:16
 */
public class Solution28 {
    /**
     * 递归
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root != null) {
            resList.add(root.val);
            resList.addAll(preorderTraversal(root.left));
            resList.addAll(preorderTraversal(root.right));
        }
        return resList;
    }

    /**
     * 非递归
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node != null) {
                resList.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        Integer[] array = {1, null, 2};
        TreeNode treeNode = TreeNode.createTreeNode(array);
        System.out.println(preorderTraversal1(treeNode));
    }

}
