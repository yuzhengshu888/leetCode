package algorithm.sum24;

/**
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/toeplitz-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @description:
 * @Author: yuzhengshu
 * @Date: 2021/2/22 11:36
 */
public class Solution {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i + 1 < matrix.length; i++) {
            int[] matrix1 = matrix[i];
            int[] matrix2 = matrix[i + 1];
            StringBuilder str1 = new StringBuilder();
            for (int n = 0; n < matrix1.length - 1; n++) {
                str1.append(matrix1[n]);
            }
            StringBuilder str2 = new StringBuilder();
            for (int n = 1; n < matrix2.length; n++) {
                str2.append(matrix2[n]);
            }
            if (!str1.toString().equals(str2.toString())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(isToeplitzMatrix(input));
    }
}
