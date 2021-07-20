package algorithmFour;

import java.util.Arrays;

/**
 * @author yuzhengshu
 * @description: 1877. 数组中最大数对和的最小值1877. 数组中最大数对和的最小值
 * @date 2021/7/20 9:20
 */
public class Solution16 {
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int asn = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            asn = Math.max(nums[left] + nums[right], asn);
            left++;
            right--;
        }
        return asn;
    }

    public static void main(String[] args) {
        System.out.println(minPairSum(new int[]{3, 5, 4, 2, 4, 6}));
    }
}
