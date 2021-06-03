package algorithmOne;

import java.util.HashMap;

/**
 * @description: 523. 连续的子数组和
 * @Author: yuzhengshu
 * @Date: 2021年6月2日 09:40
 */
public class Solution18 {
    /**
     * 暴力法,超时
     */
    public static boolean checkSubarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] sum = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j + i < sum.length; j++) {
                int sum1 = sum[j + i] - sum[j - 1];
                if (sum1 % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 优化 22ms
     */
    public static boolean checkSubarraySum1(int[] nums, int k) {
        int length = nums.length;
        if (nums.length < 2) {
            return false;
        }
        int[] sum = new int[length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < length; i++) {
            sum[i + 1] = sum[i] + nums[i];
            int remainder = sum[i + 1] % k;
            if (map.get(remainder) != null) {
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }

    /**
     * 急速 2ms
     */
    public boolean checkSubarraySum3(int[] nums, int k) {
        //先排除连续两个零的情况
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    return true;
                }
            }
            if (sum < k) {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 6};
        int[] nums1 = {1, 0, 1};
        int[] nums2 = {1, 2, 12};
        int[] nums4 = {1, 1};
        System.out.println(checkSubarraySum(nums4, 1));
        System.out.println(checkSubarraySum1(nums4, 1));
    }
}
