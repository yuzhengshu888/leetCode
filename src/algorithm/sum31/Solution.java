package algorithm.sum31;

import algorithm.sum15.TreeNode;

import java.util.*;

/**
 * @description: 993.二叉树的堂兄弟节点
 * @Author: yuzhengshu
 * @Date: 2021/5/17 10:22
 */
public class Solution {
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = queue.size();
        int idX = -1, idY = -1;
        TreeNode tempNode;
        List<Integer> singleLevel = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (i == 0) {
                for (int n = 0; n < singleLevel.size(); n++) {
                    if (singleLevel.get(n) != null && x == singleLevel.get(n)) {
                        idX = n;
                    }
                    if (singleLevel.get(n) != null && y == singleLevel.get(n)) {
                        idY = n;
                    }
                }
                if ((idX != -1 && idY == -1) || (idX == -1 && idY != -1)) {
                    return false;
                } else if (idX + idY != -2) {
                    if (Math.abs(idX - idY) != 1) {
                        return true;
                    } else {
                        return (idX + idY) % 4 != 1;
                    }
                }
                i = queue.size();
                singleLevel = new ArrayList<>();
            }
            tempNode = queue.poll();
            if (tempNode == null) {
                singleLevel.add(null);
            } else {
                singleLevel.add(tempNode.val);
                queue.add(tempNode.left);
                queue.add(tempNode.right);
            }
            i--;
        }
        return true;
    }


    public static void main(String[] args) {
        Integer[] integers = {1, 2, 5, 3, 8, 9, 6, 14, 4, 13, 12, 17, 16, 25, 7, 22, 41, 10, 11, 24, null, 29, 39, null, 45, 47, 67, 38, 35, 60, 15, 32, null, 48, null, 43, 20, null, 18, 87, 30, 49, null, 53, 88, 54, null, null, null, null, null, null, 77, 37, 70, 84, 90, 23, 19, null, 42, 57, null, null, 59, 21, 26, 40, 36, 94, null, 33, 51, 74, null, 61, null, null, null, null, 64, null, null, 50, 52, null, 72, null, null, null, null, 28, 56, 34, 27, 58, 68, 93, null, 83, 85, 71, 75, 46, 55, 91, 62, 99, null, null, null, 65, null, 73, null, null, 96, null, null, null, null, null, null, null, 92, null, null, null, null, null, 66, 76, 80, 69, 31, null, 82, null, null, null, 100, null, null, null, null, null, 95, null, 89, null, 78, 79, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 86, 81, null, null, 44, 98, null, null, null, 97, null, null, null, null, null, null, null, null, null, null, null, null, 63};
        TreeNode treeNode5 = TreeNode.createTreeNode(integers);
        System.out.println(isCousins(treeNode5, 55, 58));
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isCousins(treeNode5, 58, 55));
    }
}
