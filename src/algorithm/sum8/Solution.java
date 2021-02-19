package algorithm.sum8;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2020/12/14 19:30
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 优化: 其实不用关系具体的数学数学 ,直接往 数据中添加知道 numRows,再倒序添加 至0即可
 */
public class Solution {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<ArrayList<String>> allList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<String> list = new ArrayList<String>();
            allList.add(list);
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int remainder = i % (numRows * 2 - 2) + 1; //余数
            //字符在竖线上
            if (remainder <= numRows) {
                int index = remainder - 1;
                ArrayList<String> strings = allList.get(index);
                strings.add(String.valueOf(chars[i]));
            }
            //字符在斜线上
            else {
                int index = numRows * 2 - remainder - 1;
                ArrayList<String> strings = allList.get(index);
                strings.add(String.valueOf(chars[i]));
            }
        }
        StringBuilder result = new StringBuilder();
        for (ArrayList<String> strings : allList) {
            for (String string : strings) {
                result.append(string);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
    }
}
