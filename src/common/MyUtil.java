package common;

public class MyUtil {
    public static String castNums(String str) {
        return str.replace("]", "}").replace("[", "{");
    }

    public static int fastPower(int n, int count) {
        if (count <= 0) {
            return 1;
        }
        if (count == 1) {
            return n;
        }
        int a = n / 2;
        int b = n % 2;
        int power = fastPower(n, a);
        return power * power * fastPower(n, b);
    }
}
