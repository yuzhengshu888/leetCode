package algorithmOne;

import java.util.Arrays;

/**
 * @description: 300.最长递增子序列
 * @Author: yuzhengshu
 * @Date: 2021年5月27日 16:39
 */
public class Solution6 {
    /**
     * 动态规划解法: 时间复杂度n^2
     * dp[i] 表示长度为i时且含有num[i]的最长递增子序列长度 且有dp[0]=1
     * 那么dp[i] 和dp[j] 在计算dp[i] 之前，我们已经计算出 dp[0],dp[1]...dp[j-1],dp[j] 0<=j<i的值
     * 在num[i]>num[j]情况下一定有
     * dp[i] = max(dp[j])+1
     * 如果一个num[i]>num[j]的情况都不存在,那么dp[i]=1
     * 最后的结果为dp数组中的最大值
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 求dp[i] = max(dp[j])+1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return dp[nums.length-1];
    }
    /**
     * 贪心法
     * 不会
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }
}
