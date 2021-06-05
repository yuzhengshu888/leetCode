package algorithmOne;

/**
 * @description: 2 的幂
 * @Author: yuzhengshu
 * @Date: 2021年5月31日 11:40
 */
public class Solution11 {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) <= 1;
    }

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0));
    }
}
