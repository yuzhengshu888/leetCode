package algorithmTwo;

/**
 * @description: 486. 预测赢家
 * @Author: yuzhengshu
 * @Date: 2021年6月16日 10:31
 */
public class Solution9 {

    public static boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        //dp[i][j] 表示从 在区间[i....j] 先手的净胜分( i<=j )
        int[][] dp = new int[length][length];
        //对[1,1]的净胜分先手等于 num[i];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        //如果甲对乙的净胜分为dp[i][j] 那么乙对甲的净胜分为 -dp[i][j]
        //如果甲拿nums[i]，那么变成乙先手面对区间[i+1...j]，这段区间内乙对甲的净胜分为dp[i+1][j]；那么甲对乙的净胜分就应该是nums[i] - dp[i+1][j]。
        //如果甲拿nums[j]，同理可得甲对乙的净胜分为是nums[j] - dp[i][j-1]。
        //转移方程: dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
        //          (j,i+1)
        //             ↓
        // (j-1,i) → (j,i)
        // eg:5 3 4 5
        //    0  1  2  3
        // 0  5  x6 x5 x4
        // 1     3  x2 x3
        // 2        4  x1
        // 3           5
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }

    /**
     * 空间优化
     */
    public boolean PredictTheWinner1(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        //原数组 从元数据的起始位置开始 目标数组 目标数组的开始起始位置 要copy的数组的长度
        System.arraycopy(nums, 0, dp, 0, length);
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] >= 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 2};
        System.out.println(PredictTheWinner(nums));
    }


}
