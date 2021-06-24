package algorithmTwo;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 98. 验证二叉搜索树
 * @Author: yuzhengshu
 * @Date: 2021年6月23日 17:16
 */
public class Solution25 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    /**
     * 中序遍历 ,对二叉平衡树中序遍历的结果一定是升序的
     * 左->中->右
     */
    public boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;//用了记录上一个值

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] nums = {2, 1, 3};
        TreeNode root = TreeNode.createTreeNode(nums);
        System.out.println(new Solution25().isValidBST(root));
    }
}
