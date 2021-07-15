package algorithmFour;

import java.util.Arrays;

//1846. 减小和重新排列数组后的最大元素
public class Solution6 {
    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 0; i + 1 < arr.length; i++) {
            arr[i + 1] = Math.min(arr[i] + 1, arr[i + 1]);
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 3, 4}));
    }
}
