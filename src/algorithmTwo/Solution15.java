package algorithmTwo;

import java.util.*;

//1239. 串联字符串的最大长度
public class Solution15 {
    //使用set
    public int maxLength(List<String> arr) {
        int maxLength = 0;
        int size = arr.size();
        List<Set<Character>> list = new ArrayList<>(size);
        for (String s : arr) {
            Set<Character> set = new HashSet<>(s.length());
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            if (set.size() == s.length()) {
                list.add(set);
                maxLength = Math.max(maxLength, set.size());
            }

        }
        for (int i = 0; i < list.size(); i++) {
            int dfs = dfs(list, list.get(i), i, maxLength);
            maxLength = Math.max(dfs, maxLength);
        }
        return maxLength;
    }

    public int dfs(List<Set<Character>> list, Set<Character> set, int start, int maxLength) {
        //中断条件1
        if (start > list.size()) {
            return maxLength;
        }
        for (int i = start + 1; i < list.size(); i++) {
            Set<Character> characters = list.get(i);
            Set<Character> all = new HashSet<>();
            all.addAll(characters);
            all.addAll(set);
            if (all.size() == set.size() + characters.size()) {
                maxLength = Math.max(maxLength, all.size());
                int dfs = dfs(list, all, i, maxLength);
                maxLength = Math.max(maxLength, dfs);
            }
        }
        return maxLength;
    }

    //位运算优化
    //一串字符串可以用一个Integer 的值来存,因为Integer 的范围是2^32 可以用每一位来表示一个字母,因为最多有26个字母
    //将字符串转换为Integer
    //4ms
    public int maxLength1(List<String> arr) {
        int maxLength = 0;
        int size = arr.size();
        List<Integer> maskList = new ArrayList<>(size);
        for (String s : arr) {
            int mask = 0;
            int length = 0;
            for (char c : s.toCharArray()) {
                int a = c - 'a';
                //判断重复的情况
                if (((mask >> a) & 1) != 0) {
                    mask = 0;
                    break;
                }
                mask = mask | (1 << a);
                length++;
            }
            if (mask > 0) {
                maskList.add(mask);
                maxLength = Math.max(maxLength, length);
            }
        }
        for (int i = 0; i < maskList.size(); i++) {
            int dfs = dfsChar(maskList, maskList.get(i), i, maxLength);
            maxLength = Math.max(dfs, maxLength);
        }
        return maxLength;
    }

    private int dfsChar(List<Integer> list, Integer s, int start, int maxLength) {
        //中断条件1
        if (start > list.size()) {
            return maxLength;
        }
        for (int i = start + 1; i < list.size(); i++) {
            Integer integer = list.get(i);
            if ((integer & s) == 0) {
                int sum = integer | s;
                maxLength = Math.max(maxLength, Integer.bitCount(sum));
                int dfs = dfsChar(list, sum, i, maxLength);
                maxLength = Math.max(maxLength, dfs);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        List<String> arrs = new ArrayList(Arrays.asList("a", "b", "c"));
        System.out.println(new Solution15().maxLength(arrs));
        System.out.println(new Solution15().maxLength1(arrs));
    }
}
