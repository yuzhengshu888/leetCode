package algorithmFour;

import java.util.Arrays;

/**
 * @author yuzhengshu
 * @description: 26. 删除有序数组中的重复项
 * @date 2021/7/20 19:12
 */
public class Solution19 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int asnCount = 1, currentIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[currentIndex]) {
                asnCount++;
                currentIndex++;
            }
            nums[currentIndex] = nums[i];
        }
        return asnCount;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
