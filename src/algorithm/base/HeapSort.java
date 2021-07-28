package algorithm.base;

import java.util.Arrays;

/**
 * @author yuzhengshu
 * @description: 堆排序
 * @date 2021/7/28 16:02
 */
public class HeapSort {
    public void heapSort(int[] nums) {
        int len = nums.length - 1;
        //1.建立一个大根堆, 他的root节点是最大的
        buildMaxHeap(nums, len);
        //2.调整根
        for (int i = len; i >= 1; --i) {
            //交换末端节点 和 根节点的位置 ,然后之前的根节点已经是最大了 所以不再参加调整了
            swap(nums, i, 0);
            len -= 1;
            maxHeapify(nums, 0, len);
        }
    }

    public void buildMaxHeap(int[] nums, int len) {
        //这里为什么 i = len/2 说明一下,调整是从最右端的叶子节点开始调整的, 这时它的父节点为 len/2
        //备注 FatherIndex * 2 +1 = LeftSonIndex
        //转换 FatherIndex =  LeftSonIndex/2
        for (int i = len / 2; i >= 0; --i) {
            maxHeapify(nums, i, len);
        }
    }

    public void maxHeapify(int[] nums, int i, int len) {
        //乘2可以用 << 替换
        while (i * 2 + 1 <= len) {
            int leftIndex = (i * 2) + 1;
            int rightIndex = (i * 2) + 2;
            int large = i;
            //这里写的比较巧妙 ,一次性可以找出 root leftSon rightSon 中的最大值
            if (leftIndex <= len && nums[leftIndex] > nums[i]) {
                large = leftIndex;
            }
            if (rightIndex <= len && nums[rightIndex] > nums[large]) {
                large = rightIndex;
            }
            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
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
        int[] ints = {9, 8, 7, 6, 5, 4, 10};
        new HeapSort().heapSort(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println("--");
    }
}
