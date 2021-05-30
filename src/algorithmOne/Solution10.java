package algorithmOne;

public class Solution10 {
    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] sums;
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        sums = new int[n + 1][m + 1];
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                sums[y][x] = sums[y - 1][x] + sums[y][x - 1] - sums[y - 1][x - 1] + matrix[y - 1][x - 1];
                if (sums[y][x] == target) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}};
        System.out.println(numSubmatrixSumTarget(nums, 0));
    }
}
