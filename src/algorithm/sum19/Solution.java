package algorithm.sum19;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2020/12/28 21:48
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class Solution {
    /*
     * 暴力解法
     */
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int sumArea = heights[i];
            //后滚
            int a = i;
            int b = i;
            for (; a + 1 < heights.length; a++) {
                if (heights[a + 1] >= heights[i]) {
                    sumArea = sumArea + heights[i];
                } else {
                    break;
                }
            }
            //前滚
            for (; b - 1 >= 0; b--) {
                if (heights[b - 1] >= heights[i]) {
                    sumArea = sumArea + heights[i];
                } else {
                    break;
                }
            }
            maxArea = Math.max(maxArea, sumArea);
        }
        return maxArea;
    }

    /**
     * 单调栈
     * 当右边的高度低于左边的高度的时候,就能确定一个被包围的面积
     */
    public static int largestRectangleArea1(int[] heights) {
        int maxArea=0;
        heights = Arrays.copyOf(heights, heights.length + 1);
        heights[heights.length - 1] = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int next = heights[i];
//            while (!stack.isEmpty() && next < current) {
//
//            }
            stack.push(heights[i]);
            indexStack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] a = new int[]{
                2, 1, 5, 6, 2, 3
        };
        System.out.println(largestRectangleArea(a));
        System.out.println(largestRectangleArea1(a));
    }
}
