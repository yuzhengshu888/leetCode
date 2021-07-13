package algorithmFour;

/**
 * @description: 807. 保持城市天际线
 * @Author: yuzhengshu
 * @Date: 2021年7月13日 10:26
 */
public class Solution1 {
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int length = grid.length;
        int[] topToBottom = new int[length];
        int[] leftToRight = new int[length];
        for (int i = 0; i < length; i++) {
            int max = 0;
            for (int i1 : grid[i]) {
                max = Math.max(max, i1);
            }
            topToBottom[i] = max;
        }
        for (int i = 0; i < length; i++) {
            int max = 0;
            for (int j = 0; j < length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            leftToRight[i] = max;
        }
        int asn = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                asn += Math.min(topToBottom[i], leftToRight[j]) - grid[i][j];
            }
        }
        return asn;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(maxIncreaseKeepingSkyline(nums));
    }
}
