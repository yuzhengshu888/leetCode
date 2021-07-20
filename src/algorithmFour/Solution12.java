package algorithmFour;

import java.util.Arrays;
import java.util.HashMap;

/*
 * @Description: 1329. 将矩阵按对角线排序
 * @Author: yuzhengshu
 * @Date: 2021/7/19
 **/
public class Solution12 {
    public static int[][] diagonalSort(int[][] mat) {
        int yLength = mat.length;
        int xLength = mat[0].length;
        int x = xLength - 2, y = 0;
        while (x > 0) {
            int n = Math.min(xLength - x, yLength);
            int[] temp = new int[n];
            int tempx = x;
            int tempy = y;
            for (int i = 0; i < temp.length; i++) {
                temp[i] = mat[tempy][tempx];
                tempx++;
                tempy++;
            }
            Arrays.sort(temp);
            int tempx1 = x;
            int tempy1 = y;
            for (int value : temp) {
                mat[tempy1][tempx1] = value;
                tempx1++;
                tempy1++;
            }
            x--;
        }
        x = 0;
        y = 0;
        while (y < yLength - 1) {
            int n = Math.min(yLength - y, xLength);
            int[] temp = new int[n];
            int tempx = x;
            int tempy = y;
            for (int i = 0; i < temp.length; i++) {
                temp[i] = mat[tempy][tempx];
                tempx++;
                tempy++;
            }
            Arrays.sort(temp);
            int tempx1 = x;
            int tempy1 = y;
            for (int value : temp) {
                mat[tempy1][tempx1] = value;
                tempx1++;
                tempy1++;
            }
            y++;
        }
        return mat;
    }

    public static void main(String[] args) {
//        int[][] mat = MyUtil.castToNums2("[[75,21,13,24,8],[24,100,40,49,62]]");
//        System.out.println(Arrays.deepToString(diagonalSort(mat)));
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            int v = (int) (Math.random() * 1000);
            map.put("a" + v, 1);
        }
    }
}
