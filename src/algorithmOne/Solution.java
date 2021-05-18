package algorithmOne;

import common.TreeNode;

/**
 * @description: 104. 二叉树的最大深度
 * @Author: yuzhengshu
 * @Date: 2021/5/18 16:51
 */
public class Solution {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int maxHeight = 1;
        int i = 0;
        if (root.left != null) {
            i = maxDepth(root.left);
        }
        int i1 = 0;
        if (root.right != null) {
            i1 = maxDepth(root.right);
        }
        maxHeight = Math.max(i, i1) + 1;
        return maxHeight;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTreeNode(new Integer[]{1, null, 2});
        System.out.println(maxDepth(treeNode));
    }
}
