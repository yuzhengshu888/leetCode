package algorithmThree;

/**
 * @description: 643. 子数组最大平均数 I
 * @Author: yuzhengshu
 * @Date: 2021年7月12日 11:52
 */
public class Solution29 {
    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        int left = 0, right = k - 1;
        double sum = 0, maxSum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        maxSum = sum;
        while (right < nums.length - 1) {
            right++;
            sum = sum + nums[right] - nums[left];
            if (maxSum < sum) {
                maxSum = sum;
            }
            left++;
        }
        return maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(nums, 4));
    }
}
