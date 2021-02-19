package algorithm.sum12;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2020/12/17 15:05
 */
public class Solution {
    public static int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public static void main(String[] args) {
        int[] c = new int[]{4, 5, 2, 4, 3, 3, 1, 2, 5, 4};
        int[] d = new int[]{2, 1, 4, 4, 2, 3, 2, 5, 1, 2};
        //System.out.println(maxProfit(c, 1)); //4
        int[] e = new int[]{2, 2, 1, 1, 5, 5, 3, 1, 5, 4};
        int[] f = new int[]{2, 2, 1, 1, 5, 5, 3, 1, 5, 4};
        System.out.println(maxProfit(f, 2)); //4
    }
}
