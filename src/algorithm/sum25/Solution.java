package algorithm.sum25;

/**
 * 输入："abbaca"
 * 输出："ca"
 *
 * @description:
 * @Author: yuzhengshu
 * @Date: 2021/3/9 19:30
 */
public class Solution {
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        int a = -1;
        int b = -1;
        for (int i = 0; i + 1 < chars.length; i++) {
            char aChar = chars[i];
            char bChar = chars[i + 1];
            if (aChar == bChar) {

            }
        }

        String res = S.substring(0, a) + S.substring(b);
        if (a == 0 && b == 0) {
            return res;
        }
        return "";
    }
}
