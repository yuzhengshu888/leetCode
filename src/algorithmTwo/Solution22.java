package algorithmTwo;

/**
 * @description: 70. 爬楼梯
 * @Author: yuzhengshu
 * @Date: 2021年6月22日 13:52
 */
public class Solution22 {
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
}
