package dp;

/**
 * @description: 879. 盈利计划
 * @Author: yuzhengshu
 * @Date: 2021年6月9日 09:42
 */
public class Solution4 {
    /**
     * n个员工
     * 最少 minProfit 的利润
     * 第 i 种工作会产生 profit[i] 的利润,它要求 group[i] 名成员共同参与
     * 1 <= n <= 100
     * 0 <= minProfit <= 100
     * 1 <= group.length <= 100
     * 1 <= group[i] <= 100
     * profit.length == group.length
     * 0 <= profit[i] <= 100
     * 空间过不了
     * 时间复杂度 n * (profit.length) * sunProfit
     */
    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int length = profit.length;
        int count = 0;
        int sunProfit = 0;
        int MOD = (int) 1e9 + 7;
        for (int i : profit) {
            sunProfit += i;
        }
        //dp的第三维为具体的值
        int[][][] dp = new int[length + 1][sunProfit + 1][n + 1];
        dp[0][0][0] = 1;

        for (int i = 0; i < length; i++) {
            int earnedValue = profit[i];
            int people = group[i];
            for (int j = 0; j <= sunProfit; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i + 1][j][k] = dp[i][j][k];
                    if (j - earnedValue >= 0 && k - people >= 0) {
                        dp[i + 1][j][k] = (dp[i][j][k] + dp[i][j - earnedValue][k - people]) % MOD;
                    }
                }
            }
        }
        for (int i = minProfit; i <= sunProfit; i++) {
            for (int k = 0; k <= n; k++) {
                count = (count + dp[length][i][k]) % MOD;
            }
        }
        return count;
    }

    /**
     * 逆序优化
     */
    public static int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
        int length = profit.length;
        int count = 0;
        int sunProfit = 0;
        int MOD = (int) 1e9 + 7;
        for (int i : profit) {
            sunProfit += i;
        }
        int[][] dp = new int[sunProfit + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 0; i < length; i++) {
            int earnedValue = profit[i];
            int people = group[i];
            for (int j = sunProfit; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    dp[j][k] = dp[j][k];
                    if (j - earnedValue >= 0 && k - people >= 0) {
                        dp[j][k] = (dp[j][k] + dp[j - earnedValue][k - people]) % MOD;
                    }
                }
            }
        }
        for (int i = minProfit; i <= sunProfit; i++) {
            for (int k = 0; k <= n; k++) {
                count = (count + dp[i][k]) % MOD;
            }
        }
        return count;
    }

    /**
     * 再优化
     */
    public static int profitableSchemes3(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length, MOD = (int) 1e9 + 7;
        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;
        for (int i = 0; i < len; i++) {
            int members = group[i], earn = profit[i];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i + 1][j][k] = dp[i][j][k];
                    if (j - members >= 0) {
                        dp[i + 1][j][k] = (dp[i][j][k] + dp[i][j - members][Math.max(0, k - earn)]) % MOD;
                    }
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= n; j++) {
            sum = (sum + dp[len][j][minProfit]) % MOD;
        }
        return sum;
    }

    public static int profitableSchemes4(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length, MOD = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1;
        for (int i = 0; i < len; i++) {
            for (int j = n; j >= 0; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    //如果人数够的情况下
                    if (j - group[i] >= 0) {
                        dp[j][k] = (dp[j][k] + dp[j - group[i]][Math.max(0, k - profit[i])]) % MOD;
                    }
                    //人数不够的情况下
                    else {
                        dp[j][k] = dp[j][k];
                    }
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= n; j++) {
            sum = (sum + dp[j][minProfit]) % MOD;
        }
        return sum;
    }

    /**
     * 简化下问题,缩小一维,求方案数
     */
    public static int profitableSchemesSimple(int minProfit, int[] profit) {
        int sum = 0, count = 0;
        int length = profit.length;
        for (int i : profit) {
            sum += i;
        }
        int[][] dp = new int[length + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 0; i < length; i++) {
            int earnedValue = profit[i];
            for (int j = 0; j <= sum; j++) {
                dp[i + 1][j] = dp[i][j];
                if (j - earnedValue >= 0) {
                    dp[i + 1][j] = dp[i][j] + dp[i][j - earnedValue];
                }
            }
        }

        for (int i = minProfit; i <= sum; i++) {
            count += dp[length][i];
        }
        return count;
    }

    static final int MOD = 1000_000_007;

    public int profitableSchemes5(int n, int minProfit, int[] groups, int[] profits) {
        int m = groups.length;
        int[][] counts = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            counts[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            int group = groups[i], profit = profits[i];
            for (int j = n; j >= group; j--) {
                long count = counts[j][minProfit];
                for (int k = Math.max(0, minProfit - profit); k <= minProfit; k++) {
                    count += counts[j - group][k];
                }
                counts[j][minProfit] = (int) (count % MOD);
                for (int k = minProfit - 1; k >= profit; k--) {
                    counts[j][k] = (counts[j][k] + counts[j - group][k - profit]) % MOD;
                }
            }
        }
        return counts[n][minProfit];
    }

    public static void main(String[] args) {
        int n = 10;
        int minProfit = 5;
        int[] groups = {2, 3, 5};
        int[] profits = {6, 7, 8};

        //System.out.println(profitableSchemesSimple(minProfit, profits));
        System.out.println(profitableSchemes3(n, minProfit, groups, profits));
        System.out.println(profitableSchemes4(n, minProfit, groups, profits));
    }
}
