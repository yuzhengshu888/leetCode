package algorithmOne;

import java.util.HashMap;

/**
 * @description: 560. 和为K的子数组
 * @Author: yuzhengshu
 * @Date: 2021年6月2日 10:56
 */
public class Solution19 {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
            // sum[i+1] - sum[j] = k
            // sum[j] = sum[i+1] - k
            int key = sum[i + 1] - k;
            if (map.get(key) != null) {
                count += map.get(key);
            }
            map.merge(sum[i + 1], 1, Integer::sum);
        }
        return count;
    }

    /**
     * 优化后
     */
    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.merge(sum, 1, Integer::sum);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 1, 1};
        System.out.println(subarraySum(nums, 2));
    }
}
