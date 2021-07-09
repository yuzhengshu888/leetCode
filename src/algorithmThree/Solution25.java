package algorithmThree;

/**
 * @description: 面试题 17.10. 主要元素 和169. 多数元素 的区别是169一定有这个元素,而这题可能没有
 * @Author: yuzhengshu
 * @Date: 2021年7月9日 09:18
 */
public class Solution25 {
    public static int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count = 1;
                continue;
            }
            count = (nums[i] == major ? count + 1 : count - 1);
        }
        count = 0;
        for (int i : nums) {
            if (i == major) {
                count++;
            }
        }
        return count > nums.length / 2 ? major : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3};
        System.out.println(majorityElement(nums));
    }
}
