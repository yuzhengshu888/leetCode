package algorithmFour;

import common.TreeNode;

import java.util.HashMap;

/**
 * @author yuzhengshu todo 重建二叉树
 * @description: 剑指 Offer 07. 重建二叉树
 * @date 2021/7/27 13:57
 */
public class Solution26 {
    //前序 中左右
    //中序 左中右
    HashMap<Integer, Integer> preorderMap = new HashMap<>();
    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            preorderMap.put(preorder[i], i);
        }
        for (int i = 0; i < inorder.length; i++) {
            preorderMap.put(inorder[i], i);
        }
        TreeNode asnRoot = new TreeNode(preorder[0]);
        TreeNode currentNode = asnRoot;
        for (int i = 0; i < preorder.length; i++) {
            int val = preorder[i];
        }
        return asnRoot;
    }

    public void dfs(int rootVal) {

    }
}
