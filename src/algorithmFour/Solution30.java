package algorithmFour;

/**
 * @author yuzhengshu
 * @description:
 * @date 2021/8/3 9:27
 */
public class Solution30 {
    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        while (left + 1 < nums.length && nums[left + 1] >= nums[left]) {
            left++;
        }
        int right = nums.length - 1;
        while (right > left && nums[right] >= nums[right - 1] && nums[right] > nums[left]) {
            right--;
        }
        if (right == left) {
            return 0;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 3};
        System.out.println(findUnsortedSubarray(nums));
    }
}
