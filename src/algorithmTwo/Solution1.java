package algorithmTwo;

import java.util.*;

//1449. 数位成本和为目标值的最大数字
public class Solution1 {
    public static String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -100000);
        dp[0] = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            int costValue = cost[i];
            for (int j = costValue; j <= target; j++) {
                dp[j] = dp[j];
                if (j - costValue >= 0) {
                    if (dp[j - costValue] + 1 >= dp[j]) {
                        dp[j] = dp[j - costValue] + 1;
                        List<Integer> temp = new ArrayList<>(2);
                        if (dp[j - costValue] != 0) {
                            temp.add(j - costValue);
                            temp.add(i);
                            map.put(j, temp);
                        } else {
                            temp.add(0);
                            temp.add(i);
                            map.put(j, temp);
                        }
                    }
                }
            }
        }
        if (dp[target] < 0) {
            return "0";
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Integer newKey = target;
        while (map.containsKey(newKey)) {
            List<Integer> tempList = map.get(newKey);
            newKey = tempList.get(0);

            Integer idx = tempList.get(1);
            queue.add(idx);
        }

        StringBuffer res = new StringBuffer();
        for (Integer integer : queue) {
            res.append(integer + 1);
        }
        return res.length() == 0 ? "0" : res.toString();
    }

    //优化
    public static String largestNumber1(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int c : cost) {
            for (int j = c; j <= target; ++j) {
                dp[j] = Math.max(dp[j], dp[j - c] + 1);
            }
        }
        if (dp[target] < 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        //倒序是因为我们对相同cost我们需要更大的数字
        for (int i = 8, j = target; i >= 0; i--) {
            //我们只有得到某个dp[j] = dp[j-c] +1 就可以知道它一定可以从这个地方推上去
            for (int c = cost[i]; j >= c && dp[j] == dp[j - c] + 1; j -= c) {
                sb.append(i + 1);
            }
        }
        //相当于
//        for (int i = 8, j = target; i >= 0; i--) {
//            for (int c = cost[i]; j - c >= 0; j = j - c) {
//                if (dp[j] == dp[j - c] + 1) {
//                    sb.append(i + 1);
//                }
//            }
//        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] cost = {2, 4, 6, 2, 4, 6, 4, 4, 4};
        int target = 5;
        System.out.println(largestNumber1(cost, target));
    }
}
