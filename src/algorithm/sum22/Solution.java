package algorithm.sum22;

/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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
