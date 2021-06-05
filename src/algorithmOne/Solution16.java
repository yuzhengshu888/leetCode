package algorithmOne;

/**
 * @description: 11. 盛最多水的容器
 * @Author: yuzhengshu
 * @Date: 2021年6月1日 16:36
 */
public class Solution16 {
    //暴力法
    public static int maxArea(int[] height) {
        // height * width
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int leftHeight = height[i];
            for (int j = height.length - 1; j > i; j--) {
                int rightHeight = height[j];
                if (leftHeight <= rightHeight) {
                    maxArea = Math.max(maxArea, leftHeight * (j - i));
                } else {
                    maxArea = Math.max(maxArea, rightHeight * (j - i));
                }
            }
        }
        return maxArea;
    }

    //双指针法
    public static int maxArea1(int[] height) {
        // height * width
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left != right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3};
        System.out.println(maxArea1(nums));
    }
}
