package algorithmOne;

/**
 * @description: 42. 接雨水
 * @Author: yuzhengshu
 * @Date: 2021年6月1日 17:50
 */
public class Solution17 {
    /**
     * 动态规划
     * 从左到右
     * 从右到做
     * 交叉部分最低处就是雨水的高度
     */
    public static int trap1(int[] height) {
        int length = height.length;
        int[] leftTemp = new int[height.length];
        int[] rightTemp = new int[height.length];
        int res = 0;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            temp = Math.max(temp, height[i]);
            leftTemp[i] = temp;
        }
        temp = 0;
        for (int i = length - 1; i >= 0; i--) {
            temp = Math.max(temp, height[i]);
            rightTemp[i] = temp;
        }
        for (int i = 0; i < length; i++) {
            int h = Math.min(leftTemp[i], rightTemp[i]);
            res += h - height[i];
        }

        return res;
    }

    /**
     * 双指针
     */
    public static int trap2(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};//6
        System.out.println(trap1(nums));
        System.out.println(trap2(nums));
    }
}
