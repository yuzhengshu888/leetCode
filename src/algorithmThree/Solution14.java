package algorithmThree;

import java.util.Arrays;

/**
 * @description: 88. 合并两个有序数组
 * @Author: yuzhengshu
 * @Date: 2021年7月2日 11:37
 */
public class Solution14 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums1.length);
            return;
        }
        if (n == 0) {
            return;
        }
        int[] res = new int[m + n];
        int leftPoint = 0, rightPoint = 0, cnt = 0;
        while (leftPoint < m && rightPoint < n) {
            int a = nums1[leftPoint];
            int b = nums2[rightPoint];
            if (a <= b) {
                leftPoint++;
                res[cnt++] = a;
            } else {
                rightPoint++;
                res[cnt++] = b;
            }
        }
        while (leftPoint < m) {
            res[cnt++] = nums1[leftPoint++];
        }
        while (rightPoint < n) {
            res[cnt++] = nums2[rightPoint++];
        }
        System.arraycopy(res, 0, nums1, 0, nums1.length);
    }

    //所有玩家都全力向前冲刺, 却不知道向后才是胜利之门。-《头号玩家》
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    public void swap(int[] nums1, int m, int[] nums2, int n) {
        int temp = nums1[m];
        nums1[m] = nums2[n];
        nums2[n] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
