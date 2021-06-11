package algorithmOne;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 150. 逆波兰表达式求值
 * @Author: yuzhengshu
 * @Date: 2021年6月11日 17:14
 */
public class Solution30 {

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "-":
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    stack.push(num2 - num1);
                    break;
                case "+":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num1 + num2);
                    break;
                case "*":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num1 * num2);
                    break;
                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 / num1);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        //  "2","1","+","3","*"
        //  ((2 + 1) * 3) = 9
        //  "4","13","5","/","+"
        //  (4 + (13 / 5)) = 6
        //
        //  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
        String[] strs = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(strs));
    }
}
