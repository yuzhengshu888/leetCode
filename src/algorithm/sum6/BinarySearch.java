package algorithm.sum6;

/**
 * @description: 二分查询
 * @Author: yuzhengshu
 * @Date: 2020/9/21 19:46
 */
public class BinarySearch {
    public int search(int[] numberList, int target) {
        return findWay(numberList, target, 0, numberList.length - 1);
    }

    int findWay(int[] numberList, int target, int left, int right) {
        //判断中断条件
        if (left > right) {
            return -1;
        }
        //查询
        int mid = (left + right) / 2;
        if (numberList[mid] == target) {
            return mid;
        } else if (numberList[mid] < target) {
            return this.findWay(numberList, target, mid + 1, right);
        } else {
            return this.findWay(numberList, target, left, mid + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(nums, 3));
    }
}
