package algorithmFour;

import common.TreeNode;

/**
 * @author yuzhengshu
 * @description: 124. 二叉树中的最大路径和
 * @date 2021/7/19 15:09
 */
public class Solution14 {
    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxValue;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = Math.max(0, dfs(root.left));
        int rightValue = Math.max(0, dfs(root.right));
        int priceNewpath = root.val + leftValue + rightValue;
        maxValue = Math.max(maxValue, priceNewpath);
        return root.val + Math.max(leftValue, rightValue);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{-10, 9, 20, null, null, 15, 7});
        System.out.println(new Solution14().maxPathSum(root));
    }
}
