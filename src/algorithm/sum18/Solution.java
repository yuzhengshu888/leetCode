package algorithm.sum18;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2020/12/25 11:18
 */
public class Solution {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int i = 0; i < g.length; i++) {
            int item1 = g[i];
            boolean has = false;
            for (; j < s.length; j++) {
                int item2 = s[j];
                if (item1 <= item2) {
                    j++;
                    has = true;
                    break;
                }
            }
            if (!has) {
                return i;
            }
        }
        return g.length;
    }

    public static void main(String[] args) {
        int[] g = new int[]{10, 9, 8, 7};
        int[] s = new int[]{5, 6, 7, 8};
        System.out.println(findContentChildren(g, s));
    }
}
