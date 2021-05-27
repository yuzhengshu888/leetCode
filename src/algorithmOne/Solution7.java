package algorithmOne;

/**
 * @description: 122. 买卖股票的最佳时机 II
 * @Author: yuzhengshu
 * @Date: 2021年5月27日 19:58
 */
public class Solution7 {
    /**
     * 动态规划
     */
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = 0;
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //手上无股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            //手上有股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
        }
        return dp[prices.length - 1][1];
    }

    /**
     * 贪心,找所有上升差
     */
    public static int maxProfit1(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit1(nums));
    }
}
