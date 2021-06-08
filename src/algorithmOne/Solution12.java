package algorithmOne;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 1074. 元素和为目标值的子矩阵数量
 * @Author: yuzhengshu
 * @Date: 2021年5月31日 13:43
 */
public class Solution12 {
    private int[][] sumMatrix;


    public void numMatrix(int[][] matrix) {
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

    /**
     * 暴力法
     * 先求前缀和,然后找出所有左上右下的点
     */
    public int numSubmatrixSumTarget1(int[][] matrix, int target) {
        int count = 0;
        numMatrix(matrix);

        int n = matrix.length;
        int m = matrix[0].length;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                for (int x1 = x; x1 < n; x1++) {
                    for (int y1 = y; y1 < m; y1++) {
                        int i = sumRegion(x, y, x1, y1);
                        if (i == target) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * 优化后的
     */
    public int numSubmatrixSumTarget2(int[][] matrix, int target) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) { // 枚举上边界
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) { // 枚举下边界
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c]; // 更新每列的元素和
                }
                ans += subarraySum(sum, target);
            }
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, pre = 0;
        for (int x : nums) {
            pre += x;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution12 s = new Solution12();
        int[][] nums = new int[][]{
                {1, -1}, {-1, 1}
        };
        System.out.println(s.numSubmatrixSumTarget1(nums, 0));
    }
}
