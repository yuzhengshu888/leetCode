package algorithmOne;

import java.util.HashMap;

//560. 和为K的子数组
public class Solution11 {
    // 暴力枚举
    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) {
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //前缀和
    public static int subarraySum2(int[] nums, int k) {
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
        int[] nums = new int[]{1, -1, 0};
        System.out.println(subarraySum2(nums, 0));
    }
}
