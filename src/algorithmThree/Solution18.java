package algorithmThree;

import java.util.*;

/**
 * @description: 726. 原子的数量
 * @Author: yuzhengshu
 * @Date: 2021年7月5日 09:32
 */
public class Solution18 {
    public String countOfAtoms(String formula) {
        formula = "(" + formula + ")" + "1";
        //预处理化学元素
        List<String> afterDeal = new ArrayList<>();
        char[] chars = formula.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == ')') {
                afterDeal.add(String.valueOf(chars[i]));
                continue;
            }
            String element = String.valueOf(chars[i]);
            if (Character.isDigit(element.charAt(0))) {
                while (i + 1 < chars.length) {
                    char aChar = chars[i + 1];
                    if (Character.isDigit(aChar)) {
                        element = element + aChar;
                        i++;
                    } else {
                        break;
                    }
                }
                afterDeal.add(element);
            } else {
                String count = "";
                while (i + 1 < chars.length) {
                    char aChar = chars[i + 1];
                    if (aChar >= 'a' && aChar <= 'z') {
                        element = element + aChar;
                        i++;
                    } else if (Character.isDigit(aChar)) {
                        count = count + aChar;
                        i++;
                    } else {
                        break;
                    }
                }
                afterDeal.add(element);
                if (!"".equals(element) && isNumber(element) == null) {
                    afterDeal.add("".equals(count) ? "1" : count);
                }
            }
        }
        System.out.println(afterDeal);
        ArrayList<String> deque = new ArrayList<>();
        for (int i = 0; i < afterDeal.size(); i++) {
            String s = afterDeal.get(i);
            int multiple = 1;
            if (")".equals(s)) {
                int j = deque.size() - 1;
                String s1 = afterDeal.get(i + 1);
                if (isNumber(s1) != null) {
                    multiple = isNumber(s1);
                    afterDeal.remove(i + 1);
                }
                String poll = deque.get(j);
                while (!"(".equals(poll)) {
                    Integer number = isNumber(poll);
                    if (number != null) {
                        deque.set(j, String.valueOf(number * multiple));
                    }
                    j--;
                    poll = deque.get(j);
                }
                deque.remove(j);
            } else {
                deque.add(s);
            }
        }

        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < deque.size(); i = i + 2) {
            String key = deque.get(i);
            Integer integer = map.get(key);
            if (integer == null) {
                map.put(key, Integer.valueOf(deque.get(i + 1)));
            } else {
                map.put(key, integer + Integer.parseInt(deque.get(i + 1)));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        map.forEach((k, v) -> {
            stringBuilder.append(k);
            if (v > 1) {
                stringBuilder.append(v);
            }
        });
        return stringBuilder.toString();
    }

    public Integer isNumber(String s) {
        char c = s.charAt(0);
        if (Character.isDigit(c)) {
            return Integer.parseInt(s);
        }
        return null;
    }


    public static void main(String[] args) {
        String formula = "(H)";
        System.out.println(new Solution18().countOfAtoms(formula));
    }
}
