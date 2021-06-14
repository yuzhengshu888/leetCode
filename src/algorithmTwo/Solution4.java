package algorithmTwo;

import java.util.HashMap;
import java.util.Map;

//5784. 重新分配字符使所有字符串都相等
public class Solution4 {
    public static boolean makeEqual(String[] words) {
        int length = words.length;
        HashMap<Character, Integer> map = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                map.merge(aChar, 1, Integer::sum);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value / length == 0 || value % length != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"a", "a", "a", "a"};
        System.out.println(makeEqual(strs));
    }
}
