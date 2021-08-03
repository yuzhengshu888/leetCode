package algorithmFour;

import common.MyUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author yuzhengshu
 * @description: 743. 网络延迟时间
 * @date 2021/8/2 13:44
 */
public class Solution29 {
    HashMap<Integer, List<Node>> map;
    HashSet<Integer> arrivedNodes;
    int n;

    private static class Node {
        int nextNode;
        int distance;

        public Node(int nextNode, int distance) {
            this.nextNode = nextNode;
            this.distance = distance;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        map = new HashMap<>(n);
        this.n = n;
        arrivedNodes = new HashSet<>();
        for (int[] time : times) {
            List<Node> orDefault = map.getOrDefault(time[0], new ArrayList<>());
            orDefault.add(new Node(time[1], time[2]));
            map.put(time[0], orDefault);
        }
        if (map.get(k) == null) {
            return -1;
        }
        int dfs = dfs(k);
        if (n != arrivedNodes.size()) {
            return -1;
        }
        return dfs;
    }

    public int dfs(int currentNode) {
        arrivedNodes.add(currentNode);
        List<Node> nodes = map.get(currentNode);
        if (nodes == null) {
            return 0;
        }
        if (n == arrivedNodes.size()) {
            return 0;
        }
        int max = Integer.MAX_VALUE;
        for (Node node : nodes) {
            int childNodeTime = dfs(node.nextNode);
            max = Math.max(max, childNodeTime + node.distance);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] nums = MyUtil.castToNums2("[[1,2,1],[2,3,2],[1,3,2]]");
        int n = 3;
        int k = 1;
        System.out.println(new Solution29().networkDelayTime(nums, n, k));

        int[][] nums1 = MyUtil.castToNums2("[[1,2,1],[2,1,3]]");
        int n1 = 2;
        int k1 = 2;
        System.out.println(new Solution29().networkDelayTime(nums, n, k));

        int[][] nums2 = MyUtil.castToNums2("[[2,1,1],[2,3,1],[3,4,1]]");
        int n2 = 4;
        int k2 = 2;
        System.out.println(new Solution29().networkDelayTime(nums, n, k));
    }
}
