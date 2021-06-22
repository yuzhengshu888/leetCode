package design;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 155. 最小栈
 * @Author: yuzhengshu
 * @Date: 2021年6月22日 14:22
 */
public class MinStack {
    static class Temp {
        int val;
        int minIndex;
    }

    List<Temp> list;

    public MinStack() {
        list = new ArrayList<>();
    }

    /**
     * 入栈
     */
    public void push(int val) {
        Temp temp = new Temp();
        temp.val = val;
        int min = getMin();
        if (val <= min) {
            temp.minIndex = list.size();
        } else {
            temp.minIndex = list.get(list.size() - 1).minIndex;
        }
        list.add(temp);
    }

    /**
     * 出栈
     */
    public void pop() {
        list.remove(list.size() - 1);
    }

    /**
     * 取栈顶
     */
    public int top() {
        return list.get(list.size() - 1).val;
    }

    /**
     * 取栈的最小元素
     */
    public int getMin() {
        if (list.size() == 0) {
            return Integer.MAX_VALUE;
        }
        Temp topTemp = list.get(list.size() - 1);
        return list.get(topTemp.minIndex).val;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        int min = minStack.getMin();
        minStack.pop();
        int min1 = minStack.getMin();
        minStack.pop();
        int min2 = minStack.getMin();
        minStack.pop();
        int min3 = minStack.getMin();
        System.out.println("....");
    }
}
