package algorithmTwo;

import java.util.*;

/**
 * @description: 17. 电话号码的字母组合
 * @Author: yuzhengshu
 * @Date: 2021年6月21日 16:37
 */
public class Solution19 {
    /**
     * 2 a,b,c
     * 3 d,e,f
     * 4 g,h,i
     * 5 j,k,l
     * 6 m,n,o
     * 7 p,q,r,s
     * 8 t,u,v
     * 9 w,x,y,z
     */
    static HashMap<Integer, List<String>> map = new HashMap<>();

    static {
        map.put(2, new ArrayList<>(Arrays.asList("a", "b", "c")));
        map.put(3, new ArrayList<>(Arrays.asList("d", "e", "f")));
        map.put(4, new ArrayList<>(Arrays.asList("g", "h", "i")));
        map.put(5, new ArrayList<>(Arrays.asList("j", "k", "l")));
        map.put(6, new ArrayList<>(Arrays.asList("m", "n", "o")));
        map.put(7, new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        map.put(8, new ArrayList<>(Arrays.asList("t", "u", "v")));
        map.put(9, new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
    }

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        return dfs("", digits);
    }

    public List<String> dfs(String previous, String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            res.add(previous);
            return res;
        }

        int c = digits.charAt(0) - 48;
        List<String> strings = map.get(c);
        for (String string : strings) {
            String s = previous + string;
            String substring = digits.substring(1);
            res.addAll(dfs(s, substring));
        }
        return res;
    }

    public List<String> letterCombinations1(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution19().letterCombinations("222"));
        System.out.println(new Solution19().letterCombinations1("222"));
    }
}
