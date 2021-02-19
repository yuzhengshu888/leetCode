package algorithm.sum3;

import java.util.*;

/**
 * @description: 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @Author: yuzhengshu
 * @Date: 2020/6/16 21:13
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //基本思路.3sum=>2sum
        //然后去重
        //key: 两数之和, value :list[[1,2],[3,4]]
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int n = 0; n < nums.length; n++) {
            for (int m = n + 1; m < nums.length; m++) {
                int sum2 = nums[n] + nums[m];
                if (map.get(sum2) != null) {
                    map.get(sum2).add(Arrays.asList(n, m));
                } else {
                    List<List<Integer>> lists = new ArrayList<>();
                    map.put(sum2, lists);
                }
            }
        }
        ArrayList<Integer> nums2 = new ArrayList<>();
        map.forEach((k, v) -> nums2.add(k));
        int[] ints = nums2.stream().mapToInt(Integer::valueOf).toArray();
        return null;
    }

    //求两数之和
    public int[] twoSum(int[] nums, int target) {
        //key:值 value:下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                int[] result = new int[2];
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
            int sub = target - nums[i];
            map.put(sub, i);
        }
        return null;
    }
}
