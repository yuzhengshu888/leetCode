package algorithmThree;

/**
 * @description: 167. 两数之和 II - 输入有序数组
 * @Author: yuzhengshu
 * @Date: 2021年7月5日 17:29
 */
public class Solution19 {
    //暴力法
    public int[] twoSum(int[] numbers, int target) {
        int[] asn = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int number1 = numbers[j];
                if (number + number1 == target) {
                    asn[0] = number;
                    asn[1] = number1;
                    return asn;
                }
            }
        }
        return asn;
    }

    //双指针
    public int[] twoSum1(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }

    //二分查询 n*logn
    public int[] twoSum3(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

}
