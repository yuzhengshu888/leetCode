package exam.exam8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuzhengshu
 * @description:
 * @date 2021/8/3 16:04
 */
public class Solution1 {
    static List<String> rangeSummary(int[] nums) {
        List<String> resList = new ArrayList<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            if (right == nums.length - 1 || nums[right + 1] - nums[right] > 1) {
                String str = left == right ? String.valueOf(nums[left]) : nums[left] + "->" + nums[right];
                resList.add(str);
                left = right;
            }
            right++;
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        System.out.println(rangeSummary(nums));
    }
}
