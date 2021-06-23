package algorithmTwo;

import common.TreeNode;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2021年6月23日 17:16
 */
public class Solution25 {
    int rootVal;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!dfsLeft(root)) {
            return false;
        }
        if (!dfsRight(root)) {
            return false;
        }
        rootVal = root.left.val;
        if (!isValidBST(root.left)) {
            return false;
        }
        rootVal = root.right.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }

    public boolean dfsLeft(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val >= rootVal) {
            return false;
        }
        dfsLeft(root.left);
        dfsLeft(root.right);
        return true;
    }

    public boolean dfsRight(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val <= rootVal) {
            return false;
        }
        dfsRight(root.left);
        dfsRight(root.right);
        return true;
    }

    public static void main(String[] args) {
        Integer[] nums = {2, 1, 3};
        TreeNode root = TreeNode.createTreeNode(nums);
        System.out.println(new Solution25().isValidBST(root));
    }
}
