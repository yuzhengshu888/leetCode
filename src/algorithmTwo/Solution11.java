package algorithmTwo;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 95. 不同的二叉搜索树 II
 * @Author: yuzhengshu
 * @Date: 2021年6月17日 17:33
 */
public class Solution11 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        List<TreeNode> treeNodes = generateTrees(1, n);
        return treeNodes;
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        //左右节点可能是一颗空树
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    list.add(currTree);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution11().generateTrees(3));
    }
}
