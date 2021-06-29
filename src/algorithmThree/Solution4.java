package algorithmThree;

/**
 * @description: 剑指 Offer 10- I. 斐波那契数列
 * @Author: yuzhengshu
 * @Date: 2021年6月29日 16:41
 */
public class Solution4 {
    //F(0) = 0,   F(1) = 1
    //F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
    public static int fib(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 0; i < n - 1; i++) {
            dp[i + 2] = (dp[i + 1] + dp[i]) % 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(0));
    }
}
