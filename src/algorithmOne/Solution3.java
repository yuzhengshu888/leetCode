package algorithmOne;

import common.TreeNode;

/**
 * @description: 110. 平衡二叉树
 * @Author: yuzhengshu
 * @Date: 2021年5月20日 14:27
 */
public class Solution3 {

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) >= 2) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {

        Integer[] array = new Integer[]{3, 9, 20, null, null, 15, 7};
        Integer[] array1 = new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4};
        Integer[] array2 = new Integer[]{1, null, 2, null, 3};
        Integer[] array3 = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNode.createTreeNode(array3);
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.isBalanced(treeNode));
    }

}
