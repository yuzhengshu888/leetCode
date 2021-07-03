package algorithmThree;

import common.MyUtil;

import java.util.*;

/**
 * @description: LCP 07. 传递信息
 * @Author: yuzhengshu
 * @Date: 2021年7月1日 09:34
 */
public class Solution11 {
    public static int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] ints : relation) {
                int a = ints[0];
                int b = ints[1];
                dp[i + 1][b] += dp[i][a];
            }
        }
        return dp[k][n - 1];
    }

    //BFS
    public static int bfs(int n, int[][] relation, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ints : relation) {
            int a = ints[0];
            int b = ints[1];
            List<Integer> orDefault = map.getOrDefault(a, new ArrayList<>());
            orDefault.add(b);
            map.put(a, orDefault);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int asnCount = 0;
        int i = 0;
        while (!queue.isEmpty() && i < k) {
            int size = queue.size();
            for (int i1 = 0; i1 < size; i1++) {
                Integer poll = queue.poll();
                if (map.containsKey(poll)) {
                    List<Integer> integers = map.get(poll);
                    for (Integer nextValue : integers) {
                        queue.offer(nextValue);
                    }
                }
            }
            i++;
            if (i == k) {
                while (!queue.isEmpty()) {
                    if (queue.poll() == n - 1) {
                        asnCount++;
                    }
                }
            }
        }
        return asnCount;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(MyUtil.castNums("[[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]]"));
        int[][] relation = new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        int k = 3;
        System.out.println(numWays(n, relation, k));
        System.out.println(bfs(n, relation, k));
    }
}
