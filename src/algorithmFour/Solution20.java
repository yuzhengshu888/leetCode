package algorithmFour;

import java.util.Arrays;

/**
 * @author yuzhengshu
 * @description:
 * @date 2021/7/20 19:37
 */
public class Solution20 {
    public static int[] productExceptSelf(int[] nums) {
        //求前缀积
        int[] a = new int[nums.length];
        a[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            a[i] = nums[i - 1] * a[i - 1];
        }
        //求后缀积
        int[] b = new int[nums.length];
        b[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            b[i] = nums[i + 1] * b[i + 1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = a[i] * b[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
