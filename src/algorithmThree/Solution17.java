package algorithmThree;

//5802. 统计好数字的数目
public class Solution17 {
    public static int countGoodNumbers(long n) {
        long count1 = n / 2;
        long count2 = count1;
        if (n % 2 == 1) {
            count2++;
        }
        //快速幂
        //3^50 = 3^25*3^25
        return (int) ((fastPower(5, count2) * fastPower(4, count1)) % 1000000007);
    }

    public static long fastPower(int n, long count) {
        if (count <= 0) {
            return 1;
        }
        if (count == 1) {
            return n;
        }
        long a = count / 2;
        long b = count % 2;
        long power = fastPower(n, a);
        long c = (power * power) % 1000000007;
        return (c * fastPower(n, b)) % 1000000007;
    }


    public static void main(String[] args) {
        long n = 50L;
        System.out.println(countGoodNumbers(1));
        System.out.println(fastPower(2, 10));
    }
}
