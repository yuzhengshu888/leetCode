package algorithm.sum11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2020/12/16 17:50
 * <p>
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class Solution {
    public static boolean wordPattern(String pattern, String s) {
        //建立位置关系
        char[] chars = pattern.toCharArray();
        String[] strList = s.split(" ");
        if (chars.length != strList.length) {
            return false;
        }
        Map<String, String> indexMap1 = new HashMap<>();
        Map<String, String> indexMap2 = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            String strChar = String.valueOf(chars[i]);
            String str = strList[i];
            String expectStr = indexMap1.get(strChar);
            if (expectStr == null) {
                if (indexMap2.get(str) == null) {
                    indexMap2.put(str, strChar);
                } else {
                    return false;
                }
                indexMap1.put(strChar, str);
            } else if (!str.equals(expectStr)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat fish"));
    }
}
