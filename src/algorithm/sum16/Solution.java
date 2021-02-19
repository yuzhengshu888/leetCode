package algorithm.sum16;

import java.util.*;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2020/12/23 13:27
 */
public class Solution {
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char a : chars) {
            map.merge(a, 1, Integer::sum);
        }
        Character result = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        }
        if (result == null) {
            return -1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == result) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}
