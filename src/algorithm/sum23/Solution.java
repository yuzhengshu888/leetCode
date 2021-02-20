package algorithm.sum23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 * @description:
 * @Author: yuzhengshu
 * @Date: 2021/2/20 13:36
 */
public class Solution {
    static class ThreeTuple {
        Integer number;
        Integer start;
        Integer end;

        public ThreeTuple(Integer number, Integer start, Integer end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }

        public void addNumber() {
            this.number++;
        }

        public void setEnd(Integer end) {
            this.end = end;
        }
    }


    public static int findShortestSubArray(int[] nums) {
        int max = 0;
        ArrayList<Integer> maxNumberList = new ArrayList<>();
        Map<Integer, ThreeTuple> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            ThreeTuple tuple = map.get(num);
            if (tuple == null) {
                tuple = new ThreeTuple(1, i, i);
            } else {
                tuple.addNumber();
                tuple.setEnd(i);
            }
            map.put(num, tuple);
            Integer number = tuple.number;
            if (max < number) {
                max = number;
                maxNumberList.clear();
                maxNumberList.add(num);
            } else if (max == number) {
                maxNumberList.add(num);
            }
        }
        int minLength = nums.length;
        for (Integer integer : maxNumberList) {
            ThreeTuple threeTuple = map.get(integer);
            minLength = Math.min(minLength, threeTuple.end - threeTuple.start + 1);
        }
        return minLength;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(nums));
    }
}
