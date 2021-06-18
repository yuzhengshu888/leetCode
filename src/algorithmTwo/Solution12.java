package algorithmTwo;

/**
 * @description: 483. 最小好进制
 * @Author: yuzhengshu
 * @Date: 2021年6月18日 09:30
 */
public class Solution12 {
    /**
     * (1)求这个等比数列的长度
     * 对本题来说 n为和 ,m 为等比数列长度
     * 等比数列求和 n =(1-q^m)/(1-q) <=> n-q*n = 1-q^m <=> q^m = 1-n+q*n
     * 已知不等式 1-n+q*m < q*n (n>1)
     * 有 q^m<q*n <=> m < log q n
     * 这个等比数列的 q>=2 (没有一进制)
     * <p>
     * 所以m最大为log2 n
     * <p>
     * (2)求q和m与n的关系
     * (q+1)^m > n
     * 得到一式 q+1 >n^(1/m)
     * m < log q n <=> q^m<n
     * 得到 q <n^(1/m)
     * <p>
     * 即 q <n^(1/m)<q+1
     * 说明q是 n^(1/m)的整数部分
     * <p>
     * 枚举所有可能的m,从大到小,得到的第一个满足条件的q就是答案(进制越大,长度越小)
     */
    public static String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        int mMax = (int)(Math.log(nVal) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int q = (int) Math.pow(nVal, 1.0 / m);
            long an = 1;
            long sum = 1;
            for (int i = 1; i < m; i++) {
                an = an * q;
                sum += an;
            }
            if (sum == nVal) {
                return String.valueOf(q);
            }
        }
        return Long.toString(nVal - 1);
    }

    public static void main(String[] args) {
        String str = "2251799813685247";
        System.out.println(smallestGoodBase(str));
    }
}
