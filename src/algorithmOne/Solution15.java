package algorithmOne;

/**
 * @description: 7. 整数反转
 * @Author: yuzhengshu
 * @Date: 2021年6月1日 16:18
 */
public class Solution15 {
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            res = res * 10 + digit;
        }
        res = res / 10;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(
                -123));
    }
}
