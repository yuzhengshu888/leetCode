package algorithmTwo;

/**
 * @description: 877. 石子游戏
 * @Author: yuzhengshu
 * @Date: 2021年6月16日 09:49
 */
public class Solution8 {
    // 4 5
    // 1 2 3 4
    // 5 6 1 2 3 4
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }

    public boolean stoneGame1(int[] piles) {
        return true;
    }
}
