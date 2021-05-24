package dp;

/**
 * @description: 1143. 最长公共子序列
 * @Author: yuzhengshu
 * @Date: 2021年5月24日 15:10
 */
public class Solution {
    /**
     * 两个状态转移方程
     * dp[i][j] 为长度char[i],char[j]
     *
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        //二维数组初始化的时候自动为0
        //以下为初始的三种状态
        //dp[0][0] = 0;
        //dp[0][1] = 0;
        //dp[1][0] = 0;
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[chars1.length][chars2.length];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println(longestCommonSubsequence(s1, s2));
    }
}
