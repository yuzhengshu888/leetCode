package common;

public class MyUtil {
    public static String castNums(String str) {
        return str.replace("]", "}").replace("[", "{");
    }

    public static int[] castToNums1(String str) {
        String[] split = str.replace("[", "").replace("]", "").split(",");
        int[] res = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            res[i] = Integer.parseInt(split[i]);
        }
        return res;
    }

    public static int[][] castToNums2(String str) {
        String[] split = str.replace("\n", "").replace(" ", "").split("],\\[");
        int[][] res = new int[split.length][split[0].length()];
        for (int i = 0; i < split.length; i++) {
            int[] ints = castToNums1(split[i]);
            res[i] = ints;
        }
        return res;
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
