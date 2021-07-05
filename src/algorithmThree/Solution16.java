package algorithmThree;


import java.io.IOException;
import java.util.*;

//189. 旋转数组
public class Solution16 {
    //方法1,模拟

    //方法2.计算出现的位置,交换 i和 i+K的值
    public void rotate(int[] nums, int k) {
        int i = k % nums.length;


    }

    //创建一个临时数组
    public static void rotate2(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int[] res = new int[k];
        System.arraycopy(nums, length - k, res, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        //System.out.println(Arrays.toString(nums));
        System.arraycopy(res, 0, nums, 0, res.length);
    }

    //翻转
    // 1 2 3 4 5
    //翻转后 5 4 3 2 1
    //如果k= 2
    //切分为两部分
    // 5 4  |  3 2 1
    //再翻转
    //4 5 | 1 2 3
    public static void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }


    public static void main(String[] args) {
        int k = 1;
        int[] nums = {-1, -100, 3, 99};
        rotate2(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
