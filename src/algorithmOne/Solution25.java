package algorithmOne;

/**
 * @description: 寻找两个正序数组的中位数
 * @Author: yuzhengshu
 * @Date: 2021年6月10日 17:09
 */
public class Solution25 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i1 = 0;
        int i2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int sum = length2 + length1;
        int flag = sum % 2;
        int idx = sum / 2;
        while (i1 < length1 && i2 < length2) {
            double num1 = nums1[i1];
            double num2 = nums2[i2];
            if (i1 + i2 >= idx) {
                if (flag == 1) {
                    return Math.min(num1, num2);
                } else {
                    return Math.min(num1, num2) / 2;
                }
            }
            if (num1 <= num2) {
                i1++;
            } else {
                i2++;
            }
        }
        if (i1 >= length1) {
            if (flag == 1) {
                return nums2[idx - i1];
            } else {
                return (double) (nums2[idx - i1] + nums2[idx - i1 - 1]) / 2;
            }
        }
        if (flag == 1) {
            return nums1[idx - i2];
        } else {
            return (double) (nums1[idx - i2] + nums1[idx - i2 - 1]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 10};
        int[] nums2 = {3, 11};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
