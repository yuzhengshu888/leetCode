package algorithmThree;

import java.util.HashMap;

/**
 * @description: 169. 多数元素
 * @Author: yuzhengshu
 * @Date: 2021年7月2日 15:11
 */
public class Solution15 {
    //Map法
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int maxValue = nums[0];
        for (int num : nums) {
            Integer value = map.get(num);
            if (value == null) {
                map.put(num, 1);
            } else {
                if (value + 1 > maxCount) {
                    maxCount = value + 1;
                    maxValue = num;
                }
                if (value + 1 > nums.length / 2) {
                    return num;
                }
                map.put(num, value + 1);
            }
        }
        return maxValue;
    }

    //摩尔投票
    //每个人的票可以和其他人相互抵消
    //最坏的情况下,每个人都要和最多的人相互抵消
    public static int majorityElement1(int[] nums) {
        int candidate = 0;//候选人
        int votes = 0;//获得的投票
        for (int num : nums) {
            if (votes == 0) {
                candidate = num;
            }
            if (num == candidate) {
                votes++;
            } else {
                votes--;
            }

        }
        return candidate;
    }

    //随机法,有二分之一的可能直接得到最大值,但最坏的情况可能要多次变遍历
    public int majorityElement3(int[] nums) {
        while (true) {
            int rand = (int) (Math.random() * nums.length);
            int count = 0;
            for (int num : nums) {
                if (num == nums[rand]) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                return nums[rand];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(majorityElement1(new int[]{1, 15, 6, 6}));
    }
}
