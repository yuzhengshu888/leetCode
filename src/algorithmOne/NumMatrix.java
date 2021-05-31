package algorithmOne;

/**
 * @description: 304. 二维区域和检索 - 矩阵不可变
 * @Author: yuzhengshu
 * @Date: 2021年5月31日 13:41
 */
public class NumMatrix {
    private int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            sumMatrix = new int[1][1];
            return;
        }
        sumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                sumMatrix[i][j] = sumMatrix[i][j - 1] + sumMatrix[i - 1][j] + matrix[i - 1][j - 1] - sumMatrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1] + sumMatrix[row1][col1] - sumMatrix[row2 + 1][col1] - sumMatrix[row1][col2 + 1];
    }
}
