package algorithmOne;

/**
 * @description: 1190. 反转每对括号间的子串
 * @Author: yuzhengshu
 * @Date: 2021年5月26日 10:03
 */
public class Solution4 {
    public static String reverseParentheses(String s) {
        String s3 = s;
        while (s3.contains("(")) {
            int endIndex = s3.indexOf(")");
            int startIndex = s3.substring(0, endIndex).lastIndexOf("(");
            String s1 = s3.substring(startIndex + 1, endIndex);
            String s2 = new StringBuffer(reverseParentheses(s1)).reverse().toString();
            s3 = new StringBuffer(s3).replace(startIndex, endIndex + 1, s2).toString();
        }
        return s3;
    }

    public static void main(String[] args) {
        String str = "sxmdll(q)eki(x)";
        System.out.println(reverseParentheses(str));
    }
}
