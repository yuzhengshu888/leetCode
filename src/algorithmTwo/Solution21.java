package algorithmTwo;

import java.util.Arrays;

/**
 * @description: 31. 下一个排列
 * @Author: yuzhengshu
 * @Date: 2021年6月22日 11:16
 */
public class Solution21 {
    //balance =1
    //eg:1,2,4,3,1
    //1<3
    //平衡区间扩大balance =2
    //1,2,4,1,3
    //4>3(平衡区间的最大值)
    //1,2,1,4,4(重平衡)
    //1,2,1,3,4
    //2<4
    //找出平衡区间大于2的第一个值,交换,然后return
    //1,3,1,2,4

    //eg:4,3,2,1
    //1<2
    //平衡区间扩大balance =2
    //4,3,1,2
    //3>2(平衡区间的最大值)
    //平衡区间扩大balance =3
    //4,1,3,2
    //4,1,2,3
    //4>3(平衡区间的最大值)
    //平衡区间扩大balance =4
    //4,1,2,3
    //1,2,3,4
    public void nextPermutation(int[] nums) {
        int balance = 1;
        int end = nums.length - 1;
        int maxValue = nums[end];
        for (int i = nums.length - 2; i >= 0; i--) {
            int num = nums[i];
            if (num >= maxValue) {
                balance++;
                reBalance(nums, balance);
                maxValue = nums[end];
            } else {
                for (int j = nums.length - balance; j < nums.length; j++) {
                    if (nums[j] > num) {
                        swap(nums, j, i);
                        break;
                    }
                }
                return;
            }
        }
    }

    public void reBalance(int[] nums, int balanceLength) {
        for (int i = nums.length - balanceLength; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 1};
        new Solution21().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
