package dp;

import java.util.Arrays;

/**
 * @description: 322. 零钱兑换
 * @Author: yuzhengshu
 * @Date: 2021年6月10日 15:42
 */
public class Solution6 {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (i - coin >= 0) {
                    if (dp[i] != -1 & dp[i - coin] != -1) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    } else if (dp[i - coin] != -1) {
                        dp[i] = dp[i - coin] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }

    /**
     * 优化
     */
    public static int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //这里填充的是amount + 1 很巧妙的代替的上面方法的条件,因为硬币只有1,最少也要amount次,不可能最少次数>amount
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1};
        int amount = 1;
        System.out.println(coinChange1(coins, amount));
    }
}
