package algorithmThree;

/**
 * @description: 剑指 Offer 11. 旋转数组的最小数字
 * @Author: yuzhengshu
 * @Date: 2021年6月29日 17:38
 */
public class Solution8 {
    public static int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high--;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 3};
        System.out.println(minArray(numbers));
    }
}
