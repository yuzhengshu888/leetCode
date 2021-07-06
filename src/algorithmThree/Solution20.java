package algorithmThree;

import java.util.Arrays;

/**
 * @description: 移动零
 * @Author: yuzhengshu
 * @Date: 2021年7月5日 17:42
 */
public class Solution20 {
    //暴力法
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            if (num1 == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    //双指针
    public void moveZeroes1(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
            System.out.println(Arrays.toString(nums) + "right:" + right + ",left:" + left);
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        new Solution20().moveZeroes1(new int[]{1, 0, 2, 0, 0, 3, 4, 5, 7});
    }
}
