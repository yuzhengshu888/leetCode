package algorithm.sum15;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2020/12/22 19:07
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> currentLevelList = new ArrayList<>();
        List<TreeNode> nextLevelList = new ArrayList<>();
        currentLevelList.add(root);
        if (root.left != null) {
            nextLevelList.add(root.left);
        }
        if (root.right != null) {
            nextLevelList.add(root.right);
        }
        result.add(Collections.singletonList(root.val));
        while (nextLevelList.size() > 0) {
            List<Integer> level = new ArrayList<>();
            for (TreeNode item : currentLevelList) {
                if (item.left != null) {
                    level.add(item.left.val);
                }
                if (item.right != null) {
                    level.add(item.right.val);
                }
            }
            currentLevelList = nextLevelList;
            nextLevelList = new ArrayList<>();
            for (TreeNode item : currentLevelList) {
                if (item.left != null) {
                    nextLevelList.add(item.left);
                }
                if (item.right != null) {
                    nextLevelList.add(item.right);
                }
            }
            result.add(level);
        }
        for (int i = 0; i < result.size(); i++) {
            List<Integer> integers = result.get(i);
            if (i % 2 == 1) {
                Collections.reverse(integers);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        t0.left = t1;
        t0.right = t2;
        t2.left = t3;
        t2.right = t4;

        System.out.println(zigzagLevelOrder(t0));
    }
}
