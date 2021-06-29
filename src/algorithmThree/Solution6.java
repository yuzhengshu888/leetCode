package algorithmThree;

/**
 * @description: 剑指 Offer 04. 二维数组中的查找
 * @Author: yuzhengshu
 * @Date: 2021年6月29日 17:18
 */
public class Solution6 {
    //从右上看,看这是一颗二叉平衡树
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
