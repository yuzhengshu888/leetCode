package algorithmTwo;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

//剑指 Offer 55 - I. 二叉树的深度
public class Solution29 {
    int height = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        List<TreeNode> nextLevel = bfs(list);
        while (nextLevel.size() > 0) {
            nextLevel = bfs(nextLevel);
        }
        return height;
    }

    public List<TreeNode> bfs(List<TreeNode> list) {
        List<TreeNode> res = new ArrayList<>();
        for (TreeNode treeNode : list) {
            if (treeNode.left != null) {
                res.add(treeNode.left);
            }
            if (treeNode.right != null) {
                res.add(treeNode.right);
            }
        }
        height++;
        return res;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{null});
        System.out.println(new Solution29().maxDepth(root));
    }
}
