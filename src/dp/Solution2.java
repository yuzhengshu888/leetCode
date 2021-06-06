package dp;

//474. 一和零
public class Solution2 {
    //m 个 0 和 n 个 1 。
    public static int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 0; i < length; i++) {
            String str = strs[i];
            int zeroCount = 0;
            int oneCount = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i + 1][j][k] = dp[i][j][k];
                    if (j >= zeroCount && k >= oneCount) {
                        dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j - zeroCount][k - oneCount] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    public static int findMaxForm2(String[] strs, int m, int n) {
        int length = strs.length;
        //int[][] dp = new int[m + 1][n + 1];
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 0; i < length; i++) {
            String str = strs[i];
            int zeroCount = 0;
            int oneCount = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    //dp[i + 1][j][k] = dp[i][j][k];
                    //dp[j][k] = dp[j][k];
                    if (j >= zeroCount && k >= oneCount) {
                        //dp[j][k]      = Math.max(dp[j][k],        dp[j - zeroCount][k - oneCount] + 1);
                        dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j - zeroCount][k - oneCount] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    public int findMaxForm1(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int[] zerosOnes = getZerosOnes(strs[i - 1]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    public int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }


    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(findMaxForm2(strs, m, n));
        Solution2 s = new Solution2();
        System.out.println(s.findMaxForm1(strs, m, n));
    }
}
