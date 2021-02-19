package algorithm.base;

/**
 * @description: 动态规划
 * @Author: yuzhengshu
 * @Date: 2020/9/22 11:47
 */
public class DynamicPlanning {
    static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        // 边界条件
        int a = 1;
        int b = 2;
        int result = 0;
        // 最优子结构与最终问题之间的关系
        for (int i = 3; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
    static int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        } else {
            return climbStairs1(n - 1) + climbStairs1(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(10));
        System.out.println(climbStairs1(10));
    }
}
