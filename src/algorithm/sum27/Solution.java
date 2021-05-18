package algorithm.sum27;

import algorithm.sum15.TreeNode;

/**
 * @description: 938. 二叉搜索树的范围和
 * @Author: yuzhengshu
 * @Date: 2021/4/27 13:45
 *
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 */
public class Solution {
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val <= high && root.val >= low) {
            res = root.val;
        }
        if (root.val >= low) {
            res = res + rangeSumBST(root.left, low, high);
        }
        if (root.val <= high) {
            res = res + rangeSumBST(root.right, low, high);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(18, null, null);
        TreeNode root2 = new TreeNode(7, null, null);
        TreeNode root3 = new TreeNode(3, null, null);
        TreeNode root4 = new TreeNode(5, root3, root2);
        TreeNode root5 = new TreeNode(15, null, root1);
        TreeNode root6 = new TreeNode(10, root4, root5);
        System.out.println(rangeSumBST(root6, 7, 15));

    }
}
