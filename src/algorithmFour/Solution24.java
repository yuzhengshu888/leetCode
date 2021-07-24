package algorithmFour;

import common.TreeNode;

import java.util.ArrayList;

/**
 * @author yuzhengshu
 * @description: 236. 二叉树的最近公共祖先
 * @date 2021/7/24 22:32
 */
public class Solution24 {
    /*
     * @Description: 找两个根节点不相交的路径的第一个值 备注: 太慢了
     * @Author: yuzhengshu
     * @Date: 2021/7/24
     **/
//    ArrayList<TreeNode> treeNodes = new ArrayList<>();
//    ArrayList<TreeNode> treeNodesForQ = new ArrayList<>();
//    ArrayList<TreeNode> treeNodesForP = new ArrayList<>();
//    boolean hadFindP = false;
//    boolean hadFindQ = false;
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        dfs(root, p, q);
//        int min = Math.min(treeNodesForP.size(), treeNodesForQ.size());
//        TreeNode asnRoot = null;
//        for (int i = 0; i < min; i++) {
//            TreeNode treeNode1 = treeNodesForP.get(i);
//            TreeNode treeNode2 = treeNodesForQ.get(i);
//            if (treeNode1.val == treeNode2.val) {
//                asnRoot = treeNode1;
//            } else {
//                return asnRoot;
//            }
//        }
//        return asnRoot;
//    }
//
//    public void dfs(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) {
//            return;
//        }
//        if (hadFindP && hadFindQ) {
//            return;
//        }
//        if (!hadFindP && root.val == p.val) {
//            treeNodesForP = new ArrayList<>(treeNodes);
//            treeNodesForP.add(p);
//            hadFindP = true;
//        }
//        if (!hadFindQ && root.val == q.val) {
//            treeNodesForQ = new ArrayList<>(treeNodes);
//            treeNodesForQ.add(q);
//            hadFindQ = true;
//        }
//        treeNodes.add(root);
//        dfs(root.left, p, q);
//        dfs(root.right, p, q);
//        treeNodes.remove(root);
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null) {
            return root;
        }
        if (leftNode == null && rightNode == null) {
            return null;
        }
        if (leftNode == null) {
            return rightNode;
        }
        if (rightNode == null) {
            return leftNode;
        }
        return null;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode treeNode = new Solution24().lowestCommonAncestor(root, p, q);
        if (treeNode == null) {
            System.out.println("错误");
        } else {
            System.out.println(treeNode.val);
        }

    }
}
