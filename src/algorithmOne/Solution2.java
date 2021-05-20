package algorithmOne;

import java.util.ArrayList;

import java.util.*;

/**
 * @description: 前K个高频单词
 * @Author: yuzhengshu
 * @Date: 2021年5月20日 11:23
 */
public class Solution2 {
    public static List<String> topKFrequent(String[] words, int k) {
        if (words.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, Integer> map = new HashMap<>(words.length);
        for (int i = 0; i < words.length; i++) {
            map.merge(words[i], 1, Integer::sum);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        List<String> resList = new ArrayList<>();
        list.sort((o1, o2) -> {
            int i = o2.getValue() - o1.getValue();
            if (i == 0) {
                return o1.getKey().compareTo(o2.getKey());
            } else {
                return i;
            }
        });
        for (int i = 0; i < k; i++) {
            resList.add(list.get(i).getKey());
        }
        return resList;
    }

    public static void main(String[] args) {
        String[] strings1 = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        String[] strings = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequent(strings, 4));
    }
}
