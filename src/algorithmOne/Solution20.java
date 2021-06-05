package algorithmOne;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 525. 连续数组
 * @Author: yuzhengshu
 * @Date: 2021年6月3日 11:35
 */
public class Solution20 {
    /**
     * 暴力法
     */
    public static int findMaxLength(int[] nums) {
        int length = nums.length;
        int[] zeroNums = new int[length + 1];
        int[] oneNums = new int[length + 1];
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNums[i + 1] = zeroNums[i] + 1;
                oneNums[i + 1] = oneNums[i];
            } else {
                zeroNums[i + 1] = zeroNums[i];
                oneNums[i + 1] = oneNums[i] + 1;
            }
        }
        for (int j = length; j >= 0; j--) {
            for (int i = 0; i <= length; i++) {
                int leftZero = zeroNums[i];
                int leftOne = oneNums[i];
                int rightZero = zeroNums[j];
                int rightOne = oneNums[j];
                int i1 = rightOne - leftOne;
                int i2 = rightZero - leftZero;
                if (i1 == i2 && i1 > 0) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }
        return maxLength;
    }

    /**
     *
     */
    public static int findMaxLength1(int[] nums) {
        int length = nums.length;
        int[] zeroNums = new int[length + 1];
        int[] oneNums = new int[length + 1];
        int maxLength = 0;
        // 1-0 差值,下标
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNums[i + 1] = zeroNums[i] + 1;
                oneNums[i + 1] = oneNums[i];
            } else {
                zeroNums[i + 1] = zeroNums[i];
                oneNums[i + 1] = oneNums[i] + 1;
            }
            int key = oneNums[i + 1] - zeroNums[i + 1];
            if (map.containsKey(key)) {
                Integer index = map.get(key);
                maxLength = Math.max(maxLength, i - index);
            } else {
                map.put(key, i);
            }
            //map.merge(key, i, (x, y) -> x);
        }
        return maxLength;
    }

    /**
     * 再优化
     */
    public static int findMaxLength2(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1};
        System.out.println(findMaxLength(nums));
        System.out.println(findMaxLength1(nums));
    }
}
