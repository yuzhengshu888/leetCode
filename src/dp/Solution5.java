package dp;

/**
 * @description: 518. 零钱兑换 II
 * @Author: yuzhengshu
 * @Date: 2021年6月10日 09:42
 */
public class Solution5 {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 101, 102, 103};
        int amount = 100;
        System.out.println(change(amount, coins));
    }
}
