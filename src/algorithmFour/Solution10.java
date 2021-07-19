package algorithmFour;

import java.util.Arrays;

//1838. 最高频元素的频数
public class Solution10 {
    public static int maxFrequency(int[] nums, int k) {
//        Arrays.sort(nums);
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int right = 0;
        int asnCount = 0;
        for (int left = 0; left < nums.length; left++) {
            int tempCount = 0;
            while (nums[right] == nums[left] || ((right - left) * nums[right] - (sum[right] - sum[left])) <= k) {
                tempCount = right - left + 1;
                if (asnCount <= tempCount) {
                    asnCount = tempCount;
                }
                if (right >= nums.length - 1) {
                    break;
                }
                right++;
            }
        }
        return asnCount;
    }

    public int maxFrequency1(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int l = 0, res = 1;
        for (int r = 1; r < n; ++r) {
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (total > k) {
                total -= nums[r] - nums[l];
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000, 9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946, 9966};
        int k = 3056;
        System.out.println(maxFrequency(nums, k));
    }
}
