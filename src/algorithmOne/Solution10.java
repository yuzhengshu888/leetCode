package algorithmOne;

/**
 * @description: 342. 4的幂
 * @Author: yuzhengshu
 * @Date: 2021年5月31日 09:58
 */
public class Solution10 {
    public static boolean isPowerOfFour(int n) {
        int a = 1;
        for (int i = 0; i < 16; i++) {
            if ((n ^ a) == 0) {
                return true;
            }
            a = a << 2;
        }
        return false;
    }

    /**
     * 0xaaaaaaaa 10,101,010,101,010,101,010,101,010,101,010
     */
    public boolean isPowerOfFour1(int n) {
        //n>0
        //n==1
        //唯一一个1 只出现在偶数位上面
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }


    public static void main(String[] args) {
        System.out.println(isPowerOfFour(1));
    }
}
