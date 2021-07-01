package algorithmThree;

/**
 * @description: 53. 最大子序和
 * @Author: yuzhengshu
 * @Date: 2021年7月1日 17:41
 */
public class Solution12 {
    public int maxSubArray(int[] nums) {
        //pre是以i结尾的最大连续子数组
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
