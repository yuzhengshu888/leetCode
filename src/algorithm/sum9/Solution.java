package algorithm.sum9;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2020/12/15 15:30
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static int myAtoi(String s) {
        char[] chars = s.toCharArray();
        StringBuffer str = new StringBuffer();
        for (char item : chars) {
            if (str.length() == 0) {
                if (item == ' ') {
                    continue;
                }
                if (item == '-') {
                    str.append('-');
                    continue;
                }
                if (item == '+') {
                    str.append('+');
                    continue;
                }
            }
            if (!Character.isDigit(item)) {
                break;
            }
            if (Character.isDigit(item)) {
                str.append(item);
            }
        }
        if (str.length() == 1 && (str.charAt(0) == '-' || str.charAt(0) == '+')) {
            return 0;
        }
        if (str.length() == 0) {
            return 0;
        }
        try {
            return Integer.parseInt(str.toString());
        } catch (NumberFormatException e) {
            if (str.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("   -42"));
//        System.out.println(myAtoi("4193 with words"));
//        System.out.println(myAtoi("words and 987"));
//        System.out.println(myAtoi("91283472332"));
//        System.out.println(myAtoi("-91283472332"));
//        System.out.println(myAtoi("-x 1"));
        System.out.println(myAtoi("+-12"));
    }
}
