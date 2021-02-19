package algorithm.sum22;

import java.util.Arrays;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2021/2/19 10:02
 */
public class Solution {
    public static int longestOnes(int[] A, int K) {
        int max = 0, left = 1, right = 0;
        int[] p = new int[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            p[i] = p[i - 1] + (1 - A[i - 1]);
        }
        while (right < p.length) {
            if (p[right] - p[left-1] <= K) {
                right++;
            } else {
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(longestOnes(a, k));
    }
}
