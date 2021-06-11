package algorithmOne;

import java.util.Stack;

/**
 * @description: 20. 有效的括号
 * @Author: yuzhengshu
 * @Date: 2021年6月11日 13:49
 */
public class Solution27 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            switch (aChar) {
                case ']':
                    if (stack.empty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.empty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    stack.push(aChar);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String str = "{";
        System.out.println(isValid(str));
    }
}
