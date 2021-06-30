package algorithmThree;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2021年6月30日 18:03
 */
public class Solution10 {
    public int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        Arrays.fill(res, -1);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(res);
        for (int rain : rains) {
            if (rain == 0) {
                //增加存活情况
                int size = queue.size();
                for (int i = 0; i < size; i++) {

                }
            } else {
                //改变存活情况
                int size = queue.size();
                for (int i = 0; i < size; i++) {

                }
            }
            //如果没有存活情况
            if (queue.isEmpty()) {
                return new int[0];
            }
        }
        return res;
    }
}
