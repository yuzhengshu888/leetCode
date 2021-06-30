package design;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 剑指 Offer 37. 序列化二叉树
 * @Author: yuzhengshu
 * @Date: 2021年6月30日 09:43
 */
public class Codec {
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    list.add("X");
                } else {
                    list.add(String.valueOf(poll.val));
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
        }
        return list.toString();
    }

    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] dataList = data.substring(1, data.length() - 1).split(", ");
        if ("X".equals(dataList[0])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataList[0]));
        int j = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                Integer value1;
                if ("X".equals(dataList[j])) {
                    value1 = null;
                } else {
                    value1 = Integer.parseInt(dataList[j]);
                }
                j++;
                Integer value2;
                if ("X".equals(dataList[j])) {
                    value2 = null;
                } else {
                    value2 = Integer.parseInt(dataList[j]);
                }
                j++;
                if (value1 != null) {
                    poll.left = new TreeNode(value1);
                    queue.offer(poll.left);
                }
                if (value2 != null) {
                    poll.right = new TreeNode(value2);
                    queue.offer(poll.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode treeNode = TreeNode.createTreeNode(new Integer[]{1, 2, 3, null, null, 4, 5, null, null, null, null});
        System.out.println(codec.serialize(treeNode));
        codec.deserialize("[1, 2, 3, X, X, 4, 5, X, X, X, X]");
        System.out.println(Integer.parseInt(null));
    }

}
