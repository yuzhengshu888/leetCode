package design;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 剑指 Offer 09. 用两个栈实现队列
 * @Author: yuzhengshu
 * @Date: 2021年6月29日 16:54
 */
public class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
