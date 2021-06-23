package algorithmTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 56. 合并区间
 * @Author: yuzhengshu
 * @Date: 2021年6月23日 09:40
 */
public class Solution23 {
    //    [[1,3],[2,6],[8,10],[15,18]]
    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        int start = 0, maxValue = 0;
        for (int i = 0; i < length; i++) {
            if (i + 1 < length && (intervals[i][1] >= intervals[i + 1][0] || maxValue >= intervals[i + 1][0])) {
                maxValue = Math.max(maxValue, intervals[i][1]);
                continue;
            }
            res.add(new int[]{intervals[start][0], Math.max(maxValue, intervals[i][1])});
            maxValue = 0;
            start = i + 1;
        }
        return res.toArray(new int[res.size()][2]);
    }

    //不排序的方法
    public int[][] merge1(int[][] intervals) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); ) {
                    //i,j有交集的情况
                    //(1,2)(2,3) (1,3)(2,4) (1,4)(2,3)
                    //(2,3)(1,2) (2,4)(1,3) (2,3)(1,4)
                    if (check(list.get(i), list.get(j)) || check(list.get(j), list.get(i))) {
                        list.get(i)[0] = Math.min(list.get(i)[0], list.get(j)[0]);
                        list.get(i)[1] = Math.max(list.get(i)[1], list.get(j)[1]);
                        flag = true;
                        list.remove(j);
                    } else {
                        j++;
                    }
                }
            }
        }
        int[][] res = new int[list.size()][2];
        res = list.toArray(res);
        return res;
    }

    private boolean check(int[] nums1, int[] nums2) {
        return nums1[1] >= nums2[0] && nums1[1] <= nums2[1] || nums1[0] >= nums2[0] && nums1[0] <= nums2[1];
    }

    public static void main(String[] args) {
        // {1,2},{2,3}
        // {1,4},{2,3}
        int[][] intervals = {{2, 3}, {1, 4}};
        int[][] merge = merge(intervals);
        System.out.println(Arrays.deepToString(merge));
    }
}
