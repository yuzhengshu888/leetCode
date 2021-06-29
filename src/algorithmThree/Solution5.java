package algorithmThree;

/**
 * @description: 剑指 Offer 03. 数组中重复的数字
 * @Author: yuzhengshu
 * @Date: 2021年6月29日 17:14
 */
public class Solution5 {
    public int findRepeatNumber(int[] nums) {
        int[] flags = new int[100001];
        for (int num : nums) {
            if (flags[num] == 1) {
                return num;
            } else {
                flags[num] = 1;
            }
        }
        return -1;
    }
}
