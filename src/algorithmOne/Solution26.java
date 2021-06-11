package algorithmOne;

import java.util.Arrays;

/**
 * @description: 279. 完全平方数
 * @Author: yuzhengshu
 * @Date: 2021年6月11日 09:31
 */
public class Solution26 {
    public static int numSquares(int n) {
        double sqrt1 = Math.sqrt(n);
        int sqrt = (int) sqrt1;
        if (sqrt == sqrt1) {
            return 1;
        }
        int[] nums = new int[sqrt + 1];
        for (int i = 0; i <= sqrt; i++) {
            nums[i] = i * i;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int num : nums) {
            for (int i = 0; i < dp.length; i++) {
                if (i - num >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }
        return dp[n];
    }

    public static int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int j = 0; j * j <= n; j++) {
            for (int i = 0; i < dp.length; i++) {
                if (i - j * j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n];
    }

    public int numSquares3(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = 101;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }

    /**
     * 数学方法
     * 时间复杂度 根号n
     */
    public int numSquares5(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }


    public static void main(String[] args) {
        System.out.println(numSquares2(15));
    }
}
