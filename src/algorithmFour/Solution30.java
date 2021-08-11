package algorithmFour;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author yuzhengshu
 * @description: 581. 最短无序连续子数组
 * @date 2021/8/3 9:27
 */
public class Solution30 {
    //方法1 直接排序
    public static int findUnsortedSubarray1(int[] nums) {
        int[] tempNums = new int[nums.length];
        System.arraycopy(nums, 0, tempNums, 0, nums.length);
        Arrays.sort(tempNums);
        int left = -1, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (tempNums[i] != nums[i]) {
                left = i;
                break;
            }
        }
        if (left == -1) {
            return 0;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (tempNums[i] != nums[i]) {
                right = i;
                break;
            }
        }
        return right - left + 1;
    }

    public static int findUnsortedSubarray(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 2, 3};
        System.out.println(findUnsortedSubarray(nums));
    }
}
