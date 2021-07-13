package algorithmOne;

/**
 * @description: 5. 最长回文子串
 * @Author: yuzhengshu
 * @Date: 2021年6月11日 17:32
 */
public class Solution31 {
    /**
     * 暴力法,超时 n^3
     */
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length <= 1) {
            return s;
        }
        int maxLength = 0;
        String resStr = "";
        for (int i = 0; i < chars.length - maxLength; i++) {
            for (int j = i + 1; j <= chars.length; j++) {
                //判断字符串str是否是回文串
                String substring = s.substring(i, j);
                String palindrome = isPalindrome(substring);
                if (maxLength < palindrome.length()) {
                    maxLength = palindrome.length();
                    resStr = palindrome;
                }
            }
        }
        return resStr;
    }

    public String isPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < chars.length; i++, j--) {
            if (chars[i] != chars[j]) {
                return "";
            }
        }
        return s;
    }

    //中心扩张法
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //情况1 length是奇数
            int len1 = expandAroundCenter(s, i, i);
            //情况2 length是偶数
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }


    public static void main(String[] args) {
        String str = "abba";
        System.out.println(new Solution31().longestPalindrome(str));
    }
}
