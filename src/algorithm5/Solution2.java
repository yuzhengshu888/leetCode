package algorithm5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yuzhengshu
 * @description: 446. 等差数列划分 II - 子序列
 * @date 2021/8/11 9:45
 */
public class Solution2 {
    public static int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        //key: 等差 value: 当前等差队列的数量
        List<HashMap<Long, Integer>> list = new ArrayList<>();
        for (int ignored : nums) {
            list.add(new HashMap<>());
        }
        for (int i = 1; i < nums.length; i++) {
            HashMap<Long, Integer> iMap = list.get(i);
            for (int j = 0; j < i; j++) {
                long difference = (long) nums[i] - (long) nums[j];
                HashMap<Long, Integer> jMap = list.get(j);
                Integer defaultCount = jMap.getOrDefault(difference, 0);
                ans += defaultCount;
                iMap.merge(difference, defaultCount + 1, Integer::sum);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10};
        System.out.println(numberOfArithmeticSlices(nums));
    }
}
