package algorithm.sum26;

/**
 * @description: 1006. 笨阶乘
 * @Author: yuzhengshu
 * @Date: 2021/4/1 20:27
 */
public class Solution {
    public static int clumsy(int N) {
        int res;
        if (N < 4) {
            return simpUnit(N);
        } else {
            res = simpUnit(N) + (N - 3);
            N = N - 4;
        }
        while (N >= 4) {
            res = res - simpUnit(N) + (N - 3);
            N = N - 4;
        }
        res = res - simpUnit(N);
        return res;
    }

    public static int simpUnit(int N) {
        int res;
        if (N >= 3) {
            res = N * (N - 1) / (N - 2);
        } else {
            return N;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(clumsy(4));//7
        System.out.println(clumsy(10));//12
        System.out.println(clumsy(8));//9
    }
}
