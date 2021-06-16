package algorithmTwo;

import java.util.*;

/**
 * @description: 451. 根据字符出现频率排序
 * @Author: yuzhengshu
 * @Date: 2021年6月15日 16:57
 */
public class Solution7 {
    //24ms
    public static String frequencySort(String s) {
        StringBuilder res = new StringBuilder(s.length());
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((x, y) -> y.getValue() - x.getValue());
        for (Map.Entry<Character, Integer> entry : list) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < value; i++) {
                res.append(key);
            }
        }
        return res.toString();
    }

    //14ms
    public static String frequencySort1(String s) {
        int length = s.length();
        char[] res = new char[length];
        HashMap<Character, Integer> map = new HashMap<>(length);
        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        int j = length - 1;
        for (Map.Entry<Character, Integer> entry : list) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < value; i++) {
                res[j] = key;
                j--;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String str = "cccaaaa";
        System.out.println(frequencySort1(str));
    }
}
