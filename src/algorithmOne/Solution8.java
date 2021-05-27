package algorithmOne;

/**
 * @description: 55. 跳跃游戏
 * @Author: yuzhengshu
 * @Date: 2021年5月27日 20:30
 */
public class Solution8 {
    /**
     * 贪心
     */
    public static boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int jumpDistance = nums[0];
        int traveledDistance = 0;
        while (jumpDistance != 0) {
            int maxRange = traveledDistance + jumpDistance;
            int tempMaxRange = 0;
            for (int i = traveledDistance; i < nums.length && i <= maxRange; i++) {
                if (tempMaxRange <= i + nums[i]) {
                    tempMaxRange = i + nums[i];
                    jumpDistance = nums[i];
                    traveledDistance = i;
                }
            }
            if (jumpDistance + traveledDistance >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 不贪了,老老实实一个一个跳
     */
    public boolean canJump1(int[] nums) {
        if (nums == null) {
            return false;
        }
        int k = 0;
        for (int i = 0; i <= k; i++) {
            int temp = i + nums[i];
            k = Math.max(k, temp);
            if (k >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 反向思考
     */
    public boolean canJump2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int idx = nums.length - 2;
        while (idx > 0) {
            if (nums[idx] > 0) {
                idx--;
                continue;
            }
            int left = idx - 1;
            while (left >= 0 && nums[left] <= idx - left) {
                left--;
            }
            if (left < 0) {
                return false;
            }
            idx = left - 1;
        }
        return nums[0] > 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 0};
        System.out.println(canJump(nums));
    }
}
