package algorithm5;

/**
 * @author yuzhengshu
 * @description: 413. 等差数列划分
 * @date 2021/8/10 13:19
 */
public class Solution1 {
    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            int count = 0;
            int interval = nums[i] - nums[i - 1];
            for (int j = i - 1; j >= 1; j--) {
                if (nums[j] - nums[j - 1] == interval) {
                    count++;
                } else {
                    break;
                }
            }
            dp[i] = dp[i - 1] + count;
        }
        return dp[nums.length - 1];
    }

    /*
     *  优化后的
     */
    public int numberOfArithmeticSlices1(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i) {
            //这个优化后不用再for循环
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 8, 9, 10};
        System.out.println(numberOfArithmeticSlices(nums));
    }
}
