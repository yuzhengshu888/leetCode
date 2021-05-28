package algorithmOne;

/**
 * @description: 477. 汉明距离总和
 * @Author: yuzhengshu
 * @Date: 2021年5月28日 09:40
 */
public class Solution9 {
    /**
     * 暴力法
     */
    public static int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return res;
    }

    /**
     * 按位比较
     * 如果有n个数,n个数的同一位上面有 x个零,n-x个一
     * 0 0 1 1
     */
    public static int totalHammingDistance1(int[] nums) {
        int res = 0;
        //一共最多三十位
        for (int i = 0; i <= 30; i++) {
            int x = 0;
            for (int num : nums) {
                System.out.println((num >> i) & 1);
                x = x + ((num >> i) & 1);
            }
            res += x * (nums.length - x);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 14, 2};
        System.out.println(totalHammingDistance1(nums));
    }
}
