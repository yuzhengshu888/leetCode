package algorithm.sum13;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2020/12/18 10:17
 */
public class Solution {
    public static char findTheDifference(String s, String t) {
        if (s.length() == 0) {
            return t.charAt(0);
        }
        Map<String, Long> sMap = Stream.of(s.split("")).parallel().collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        Map<String, Long> tMap = Stream.of(t.split("")).parallel().collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        for (Map.Entry<String, Long> entry : tMap.entrySet()) {
            Long tCount = entry.getValue();
            String key = entry.getKey();
            Long sCount = sMap.get(key);
            if (!tCount.equals(sCount)) {
                return key.charAt(0);
            }
        }
        return t.charAt(0);
    }

    public static void main(String[] args) {
        int ret = 0;
        ret = ret^'a';
        System.out.println(ret);
        ret = ret^'b';
        System.out.println(ret);
        ret = ret^'a';
        System.out.println(ret);
        //System.out.println(findTheDifference("abcd", "abcde"));
    }
}
