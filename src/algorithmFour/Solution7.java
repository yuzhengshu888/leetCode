package algorithmFour;

public class Solution7 {
    public static int maxSubArray(int[] nums) {
        int asn = nums[0];
        //以nums[i]结尾的最大值
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i] + nums[i], nums[i]);
            asn = Math.max(dp[i + 1], asn);
        }
        return asn;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
