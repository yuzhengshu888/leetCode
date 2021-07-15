package algorithmFour;

import java.util.*;

//买玩具
public class Solution5 {

    public static int butToy(int n, int m) {
        int[] coins = new int[]{1, 5, 10, 50};
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], 1);
        for (int coin : coins) {
            for (int i = coin; i <= m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j + 1] += dp[i - coin][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
//        System.out.println(butToy(15, 10));
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(null,1);
        System.out.println(1);
    }
}
