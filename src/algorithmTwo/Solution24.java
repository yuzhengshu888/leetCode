package algorithmTwo;

import javafx.scene.layout.Priority;

import java.util.*;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2021年6月23日 14:28
 */
public class Solution24 {
    public static int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i : arr) {
            queue.add(i);
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    /**
     * 快排法
     */
    public int[] smallestK1(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (k >= arr.length) {
            return arr;
        }
        int[] res = new int[k];
        int[] ints = fastSort(arr, k);
        System.arraycopy(ints, 0, res, 0, k);
        return res;
    }

    private int[] fastSort(int[] arr, int k) {
        int length = arr.length;
        int i = 0;
        int benchmark = arr[i];
        int[] leftList = new int[length];
        int[] rightList = new int[length];
        int leftCount = 0, rightCount = 0;
        for (int j = 0; j < length; j++) {
            if (i != j) {
                int num = arr[j];
                if (num <= benchmark) {
                    leftList[leftCount] = num;
                    leftCount++;
                } else {
                    rightList[rightCount] = num;
                    rightCount++;
                }
            }
        }
        if (leftCount + 1 == k) {
            leftList[leftCount] = benchmark;
            return leftList;
        } else if (leftCount + 1 < k) {
            leftList[leftCount] = benchmark;
            leftCount++;
            int[] res = new int[rightCount];
            System.arraycopy(rightList, 0, res, 0, rightCount);
            int[] nums = fastSort(res, k - leftCount);
            for (int num : nums) {
                leftList[leftCount] = num;
                leftCount++;
            }
            return leftList;
        } else {
            int[] res = new int[leftCount];
            System.arraycopy(leftList, 0, res, 0, leftCount);
            return fastSort(res, k);
        }
    }

    /**
     * 优化,快排可以不用生成新的数组,交互位置即可
     */
    public int[] smallestK2(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        int[] vec = new int[k];
        System.arraycopy(arr, 0, vec, 0, k);
        return vec;
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    // 基于随机的划分
    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int k = 4;
        int[] arr = {9, 1, 3, 5, 7, 2, 4, 6, 8};
        System.out.println(Arrays.toString(smallestK(arr, k)));
        System.out.println(Arrays.toString(smallestK(arr, k)));
    }
}
