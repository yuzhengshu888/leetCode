package algorithmOne;

/**
 * @description: 1049. 最后一块石头的重量 II
 * @Author: yuzhengshu
 * @Date: 2021年6月8日 15:08
 */
public class Solution23 {
    /**
     * 转换为在小于等于halfSum 的情况下尽可能往包里面塞更多的东西
     */
    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int halfSum = sum / 2;
        int[][] dp = new int[stones.length + 1][halfSum + 1];
        dp[0][0] = 1;
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            for (int j = 0; j <= halfSum; j++) {
                dp[i + 1][j] = dp[i][j];
                if (j - stone >= 0) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j - stone]);
                }
            }
        }
        for (int j = halfSum; ; --j) {
            if (dp[stones.length][j] > 0) {
                return sum - 2 * j;
            }
        }
    }

    /**
     * 优化1,我们不需要知道到底有多少种放法,只需要知道可以放or不可以
     */
    public static int lastStoneWeightII1(int[] stones) {
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        int n = stones.length, m = sum / 2;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= m; ++j) {
                if (j < stones[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = dp[i][j] || dp[i][j - stones[i]];
                }
            }
        }
        for (int j = m; ; --j) {
            if (dp[n][j]) {
                return sum - 2 * j;
            }
        }
    }

    /**
     * 滚动数组
     */
    public static int lastStoneWeightII2(int[] stones) {
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        int n = stones.length, m = sum / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int stone : stones) {
            for (int j = m; j >= 0; --j) {
                if (j < stone) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] || dp[j - stone];
                }
            }
        }
        for (int j = m; ; --j) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {31, 26, 33, 21, 40};
        System.out.println(lastStoneWeightII(nums));
        System.out.println(lastStoneWeightII1(nums));
    }
}
