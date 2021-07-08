package algorithmThree;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 930. 和相同的二元子数组
 * @Author: yuzhengshu
 * @Date: 2021年7月5日 22:34
 */
public class Solution22 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        //map key:sum value:该sum 出现的次数
        Map<Integer, Integer> cnt = new HashMap<>(nums.length);
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
