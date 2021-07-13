package algorithmThree;

import common.MyUtil;

/**
 * @description: 1232. 缀点成线
 * @Author: yuzhengshu
 * @Date: 2021年7月13日 09:38
 */
public class Solution31 {
    public static boolean checkStraightLine(int[][] coordinates) {
        int[] coordinate1 = coordinates[0];
        int x1 = coordinate1[0];
        int y1 = coordinate1[1];
        int[] coordinate2 = coordinates[1];
        int x2 = coordinate2[0];
        int y2 = coordinate2[1];

        for (int i = 2; i < coordinates.length; i++) {
            int x3 = coordinates[i][0];
            int y3 = coordinates[i][1];
            if (((y2 - y1) * (x3 - x2)) != ((y3 - y2) * (x2 - x1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = MyUtil.castNums("[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]");
        System.out.println(s);
        int[][] coordinates = new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        System.out.println(checkStraightLine(coordinates));
    }
}
