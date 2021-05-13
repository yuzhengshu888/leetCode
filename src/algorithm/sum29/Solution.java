package algorithm.sum29;

/**
 * @description: 1269:停在原地的方案数
 * @Author: yuzhengshu
 * @Date: 2021/5/13 13:59
 */
public class Solution {
    /**
     * dp[i][j] = dp[i-1][j] +dp[i-1][j-1] + dp[i-1][j+1]
     * j-1>=0;
     * j+1<=maxLength
     */
    public static int numWays(int steps, int arrLen) {
        final int MODULO = 1000000007;
        int maxColumn = Math.min(arrLen - 1, steps/2);
        int[][] dp = new int[steps + 1][maxColumn + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxColumn; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MODULO;
                }
                if (j + 1 <= maxColumn) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MODULO;
                }
            }
        }
        return dp[steps][0];
    }

    public static void main(String[] args) {
        System.out.println(numWays(27, 7));
    }
}
