package algorithmFour;

import java.util.*;

/**
 * @author yuzhengshu
 * @description:
 * @date 2021/7/19 14:35
 */
public class Solution13 {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            } else {
                set.add(nums[i]);
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    do {
                        left++;
                    } while (left + 1 < right && nums[left] == nums[left - 1]);
                    do {
                        right--;
                    } while (right - 1 > left && nums[right] == nums[right + 1]);

                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 1, 1, 2};
        System.out.println(threeSum(nums));
    }
}
