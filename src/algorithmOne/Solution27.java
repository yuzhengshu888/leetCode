package algorithmOne;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @description: 20. 有效的括号
 * @Author: yuzhengshu
 * @Date: 2021年6月11日 13:49
 */
public class Solution27 {
    public static boolean isValid(String s) {
        //Stack的数据结构已经过时,建议使用Deque
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            switch (aChar) {
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "{";
        System.out.println(isValid(str));
    }
}
