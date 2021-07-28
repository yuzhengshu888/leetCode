package algorithm.base;

import java.util.Arrays;

/**
 * @author yuzhengshu
 * @description: 堆排序
 * @date 2021/7/28 16:50
 */
public class MYHeapSort {
    public void myHeapSort(int[] nums) {
        buildHeap(nums);
        adjustHeap(nums);
    }

    private void buildHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            int leftIndex = i * 2 + 1;
            int rightIndex = i * 2 + 2;
            int largeIndex = i;
            if (leftIndex < nums.length && nums[leftIndex] > nums[largeIndex]) {
                largeIndex = leftIndex;
            }
            if (rightIndex < nums.length && nums[rightIndex] > nums[largeIndex]) {
                largeIndex = rightIndex;
            }
            if (largeIndex != i) {
                swap(nums, largeIndex, i);
            }
        }
    }


    private void adjustHeap(int[] nums) {
        for (int lastIndex = nums.length - 1; lastIndex >= 1; lastIndex--) {
            swap(nums, lastIndex, 0);
            int i = 0;
            while (i * 2 + 2 < lastIndex) {
                int leftIndex = i * 2 + 1;
                int rightIndex = i * 2 + 2;
                int largeIndex = i;
                if (leftIndex < nums.length && nums[leftIndex] > nums[largeIndex]) {
                    largeIndex = leftIndex;
                }
                if (rightIndex < nums.length && nums[rightIndex] > nums[largeIndex]) {
                    largeIndex = rightIndex;
                }
                if (largeIndex != i) {
                    swap(nums, largeIndex, i);
                    i = largeIndex;
                } else {
                    break;
                }
            }
        }
    }

    /*
     * 交换函数
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 10};
        new MYHeapSort().myHeapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
