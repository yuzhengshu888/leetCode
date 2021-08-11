package algorithm.base;

import java.util.Arrays;
import java.util.Random;

/**
 * @description: 快速排序
 * @Author: yuzhengshu
 * @Date: 2020/12/15 16:47
 */
public class QuickSort {
    public int[] sortArray(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            //int pos = randomizedPartition(nums, l, r);
            int pos = partition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

//    public int randomizedPartition(int[] nums, int l, int r) {
//        // 随机选一个作为我们的主元
//        int i = new Random().nextInt(r - l + 1) + l;
//        swap(nums, r, i);
//        return partition(nums, l, r);
//    }

    public int partition(int[] nums, int left, int right) {
        int pivot = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, pivot);
                pivot = i;
            }
        }
        return pivot;
    }
//    public int partition(int[] nums, int l, int r) {
//        int pivot = nums[r];
//        int i = l - 1;
//        for (int j = l; j <= r - 1; ++j) {
//            if (nums[j] <= pivot) {
//                i = i + 1;
//                swap(nums, i, j);
//            }
//        }
//        swap(nums, i + 1, r);
//        return i + 1;
//    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 23, 1, 2, 2};
        new QuickSort().sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}

