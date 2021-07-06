package algorithmThree;

/**
 * @description: 最长公共子串
 * @Author: yuzhengshu
 * @Date: 2021年7月5日 21:48
 */
public class Solution21 {
    public static String LCS(String str1, String str2) {
        String asn = "";
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            char a = str1.charAt(i);
            for (int j = 0; j < str2.length(); j++) {
                char b = str2.charAt(j);
                if (a == b) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > asn.length()) {
                        asn = str1.substring(i - dp[i + 1][j + 1] + 1, i + 1);
                    }
                } else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        return asn;
    }

    public static void main(String[] args) {
        String s1 = "heoll";
        String s2 = "ll";
        System.out.println(LCS(s1, s2));
    }
}
