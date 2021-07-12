package algorithmThree;

/**
 * @description: 1876. 长度为三且各字符不同的子字符串
 * @Author: yuzhengshu
 * @Date: 2021年7月12日 11:31
 */
public class Solution28 {
    public static int countGoodSubstrings(String s) {
        int count = 0;
        int left = 0, right = 2;
        while (right < s.length()) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(left + 1);
            char c3 = s.charAt(right);
            if (c1 != c2 && c2 != c3 && c1 != c3) {
                count++;
            }
            left++;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "xyzzaz";
        System.out.println(countGoodSubstrings(str));
    }
}
