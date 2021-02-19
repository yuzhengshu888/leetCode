package algorithm.sum21;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2021/2/5 17:41
 */
public class Solution {
    public static int equalSubstring(String s, String t, int maxCost) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        ArrayList<Integer> difList = new ArrayList<>();
        for (int i = 0; i < sChars.length; i++) {
            char sChar = sChars[i];
            char tChar = tChars[i];
            int difference = tChar - sChar;
            int differenceValue = Math.abs(difference);
            difList.add(differenceValue);
        }
        Collections.sort(difList);
        int count = 0;
        for (Integer integer : difList) {
            if (integer <= maxCost) {
                count++;
                maxCost = maxCost - integer;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "bcdf", 3));
        System.out.println(equalSubstring("abcd", "cdef", 3));
        System.out.println(equalSubstring("abcd", "acde", 0));
    }
}
