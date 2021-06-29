package algorithmThree;

/**
 * @description: 剑指 Offer 10- II. 青蛙跳台阶问题
 * @Author: yuzhengshu
 * @Date: 2021年6月29日 17:30
 */
public class Solution7 {
    //dp[i+2] = dp[i] + dp[i+1]
    public int numWays(int n) {
        int[] dp = new int[n + 3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 0; i + 2 < n + 1; i++) {
            dp[i + 2] = (dp[i] + dp[i + 1]) % 1000000007;
        }
        return dp[n];
    }
}
