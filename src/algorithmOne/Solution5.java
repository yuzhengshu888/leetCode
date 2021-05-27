package algorithmOne;

/**
 * @description: 461. 汉明距离
 * @Author: yuzhengshu
 * @Date: 2021年5月27日 10:03
 */
public class Solution5 {
    /**
     * 沙雕算法
     * 转换为二进制然后按位比较
     */
    public static int hammingDistance1(int x, int y) {
        char[] chars = Integer.toBinaryString(x).toCharArray();
        char[] chars1 = Integer.toBinaryString(y).toCharArray();
        int n = chars.length;
        int m = chars1.length;
        int count = 0;
        for (int i = n - 1, i1 = m - 1; i >= 0 && i1 >= 0; i--, i1--) {
            if (chars[i] != chars1[i1]) {
                count++;
            }
        }
        if (n > m) {
            for (int i = n - m - 1; i >= 0; i--) {
                if (chars[i] != '0') {
                    count++;
                }
            }
        } else if (n < m) {
            for (int i = m - n - 1; i >= 0; i--) {
                if (chars1[i] != '0') {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 优化1 异或,然后求1 的个数
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * 优化2 同上面思路,不用自带函数
     */
    public int hammingDistance2(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }

    /**
     * Brian Kernighan 算法
     * 记 f(x)f(x) 表示 xx 和 x-1x−1 进行与运算所得的结果（即 f(x)=x&(x-1))，那么 f(x)f(x) 恰为 xx 删去其二进制表示中最右侧的 11 的结果。
     * f(x)=x&(x-1) = x删除最右位1的结果
     */
    public int hammingDistance3(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(hammingDistance1(1, 4));
    }
}
