package dp;

//494. 目标和
public class Solution3 {
    //不是很好理解
    //16 ms
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target > sum) {
            return 0;
        }
        //dp 代表到前一个数为止,大小为j的解法个数
        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        dp[0][sum] = 1;
        for (int i = 1; i <= nums.length; i++) {
            int x = nums[i - 1];
            for (int value = -sum; value <= sum; value++) {
                //假设value的值为-sum,没有可能有-sum - x + sum > 0
                if (value - x + sum >= 0) {
                    dp[i][value + sum] += dp[i - 1][value - x + sum];
                }
                //假设value的值为sum,没有可能有sum - x + sum > 0
                if (value + x + sum <= 2 * sum) {
                    dp[i][value + sum] += dp[i - 1][value + x + sum];
                }
            }
        }
        return dp[nums.length][target + sum];
    }

    // sum - neg = target
    // sum +neg = all
    // sum 和 neg 都是非负整数数,因为nums[i]>=0
    // 解方程组得
    // neg = (all - target)/2
    // sum = (all + target)/2
    // 我们选择较小的值来缩小范围
    // 转换问题为求字数组的和为neg的方案数
    // 5 ms
    public static int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        //dp 代表前i个数组,子数组和为j 的方案数
        int[][] dp = new int[n + 1][neg + 1];
        //为零的时候什么都不选
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                //如果j>=num说明,可能是由 (j-num) + num得来的
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
//              else {
//                  //反之因为num 是个非负数,不可能从一个比j大的数相加变成一个比他小的数 相当于加0
//                  dp[i][j] += 0;
//              }
            }
        }
        return dp[n][neg];
    }

    //倒序优化 2ms
    public static int findTargetSumWays12(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = neg; j >= 0; j--) {
                if (j >= num) {
                    dp[j] += dp[j - num];
                }
            }
        }
        return dp[neg];
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(findTargetSumWays(nums, 2));
        System.out.println(findTargetSumWays1(nums, 2));
        System.out.println(findTargetSumWays12(nums, 2));
    }
}
