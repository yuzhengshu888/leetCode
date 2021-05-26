package dp;

/**
 * @description: 1035. 不相交的线
 * @Author: yuzhengshu
 * @Date: 2021年5月24日 15:50
 */
public class MaxUncrossedLines {
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }

    public static void main(String[] args) {
        int[] int1 = new int[]{2, 5, 1, 2, 5};
        int[] int2 = new int[]{10, 5, 2, 1, 5, 2};
        System.out.println(maxUncrossedLines(int1, int2));
    }
}
