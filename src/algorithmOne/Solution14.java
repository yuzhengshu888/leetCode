package algorithmOne;

import java.util.Arrays;

/**
 * @description: 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 * @Author: yuzhengshu
 * @Date: 2021年6月1日 11:42
 */
public class Solution14 {
    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] answer = new boolean[queries.length];
        //到第i天最少要累计吃多少个
        //这里用long存防止溢出
        long[] minEat = new long[candiesCount.length + 1];
        for (int i = 0; i < candiesCount.length; i++) {
            minEat[i + 1] = minEat[i] + candiesCount[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int favoriteType = queries[i][0];
            int favoriteDay = queries[i][1];
            int dailyCap = queries[i][2];
            //这里加1是因为 favoriteDay的时候还要吃一颗糖
            answer[i] = favoriteDay + 1 <= minEat[favoriteType + 1] && minEat[favoriteType] / dailyCap <= favoriteDay;
        }
        return answer;
    }

    public static void main(String[] args) {
        //[false,false,true,false,false]
        //[false,true,true,false,false]
        int[] a = new int[]{1, 1, 1, 1, 1, 1};
        int[][] b = new int[][]{{3, 3, 1}};
        System.out.println(Arrays.toString(canEat(a, b)));
    }
}
