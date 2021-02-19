package algorithm.sum5;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description:给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @Author: yuzhengshu
 * @Date: 2020/9/19 11:21
 */
public class Solution {
    //暴力法
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return 1;
        }
        int maxLength = 1;
        for (int a = 0; a < chars.length; a++) {
            HashSet maxStringSet = new HashSet();
            maxStringSet.add(chars[a]);
            for (int b = a + 1; b < chars.length; b++) {
                if (maxStringSet.contains(chars[b])) {
                    break;
                } else {
                    maxStringSet.add(chars[b]);
                    maxLength = Math.max(maxLength, maxStringSet.size());
                }
            }
            if (maxLength >= chars.length - a) {
                return maxLength;
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            //如果遇到重复元素,移动左指针
            if (map.containsKey(s.charAt(right))) {
                //计算左指针的移动距离:
                //移动的地方为  Max(left , 该元素上次出现的位置的下一位)
                //注意 map.get(s.charAt(right)) + 1 的大小是可能比 left 小的
                // eg:abba 的第二个a
                // 此时 left 为2,
                // 而map.get('a')+1 => 0+1 =1
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            //记录右指针元素的位置
            map.put(s.charAt(right), right);
            //计算最大距离 比较窗口的大小和 目前的最大长度
            max = Math.max(max, right - left + 1);
            //移动右指针 扩大窗口
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abba"));
//        System.out.println(lengthOfLongestSubstring2("dvdf"));
//        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring2("bbbbbb"));
//        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }
}
