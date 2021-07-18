package algorithmFour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//面试题 10.02. 变位词组
public class Solution9 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String strKey = createStrKey(str);
            map.computeIfAbsent(strKey, v -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static String createStrKey(String str) {
        int[] chars = new int[26];
        for (char c : str.toCharArray()) {
            int i = c - 'a';
            chars[i] += 1;
        }
        StringBuilder s = new StringBuilder();
        for (int aChar : chars) {
            s.append(aChar);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
