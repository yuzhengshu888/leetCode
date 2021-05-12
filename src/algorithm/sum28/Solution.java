package algorithm.sum28;

import java.util.Arrays;

/**
 * @description: 1310. 子数组异或查询
 * @Author: yuzhengshu
 * @Date: 2021/5/8 14:21
 * 链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray
 */
public class Solution {
    /**
     * 法1 暴力破解 时间复杂度 n * m
     * 在最坏的情况下 queries每个都是 0 - arr.length
     */
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            int temp = 0;
            for (int i1 = start; i1 <= end; i1++) {
                temp = arr[i1] ^ temp;
            }
            result[i] = temp;
        }
        return result;
    }

    /**
     * 法2
     * 解题须知:
     * 假如有数组[X1,X2,....Xn ]
     * (X1^X2)^X3 =X1^(X2^X3) 异或结合律
     * X1^X1 = 0 任何数和自己的异或都是0
     * 0^n = n   0异或任何数都是它本身
     * 0^X1 = X1^X1^X1
     *
     * eg
     * X[1,3] =X2^X3^X4
     *        = 0^X2^X3^X4
     *        = (X0^X1)^(X0^X1)^X2^X3^X4
     *        = (X0^X1)^(X0^X1^X2^X3^X4)
     *        = X[0,1] ^ X[0,4]
     *
     * 更普遍一点
     * X[n,m] = Xn^....^Xm
     *        = 0^Xn^....^Xm
     *        = (X0^Xn-1)^(X0^Xn-1)^Xn^....^Xm
     *        = (X0^Xn-1)^(X0^Xn-1^Xn^....^Xm)
     *        = X[0,n]^X[0,m+1]
     */
    public static int[] xorQueries1(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int[] tempXors = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            tempXors[i + 1] = tempXors[i] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int i1 = queries[i][0];
            int i2 = queries[i][1];
            result[i] = tempXors[i1] ^ tempXors[i2 + 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 8};
        int[][] b = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(Arrays.toString(xorQueries1(a, b)));
    }
}
