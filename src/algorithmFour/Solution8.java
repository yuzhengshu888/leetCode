package algorithmFour;

public class Solution8 {
    public static int minFlips(int a, int b, int c) {
        String s = Integer.toBinaryString(a);
        String s1 = Integer.toBinaryString(b);
        String s2 = Integer.toBinaryString(c);

        String t1 = formatStr(s);
        String t2 = formatStr(s1);
        String t3 = formatStr(s2);
        int asnCount = 0;
        char[] chars1 = t1.toCharArray();
        char[] chars2 = t2.toCharArray();
        char[] chars3 = t3.toCharArray();
        for (int i = 0; i < chars3.length; i++) {
            char c1 = chars1[i];
            char c2 = chars2[i];
            char c3 = chars3[i];
            if (c3 == '0') {
                if (c1 == '1') {
                    asnCount++;
                }
                if (c2 == '1') {
                    asnCount++;
                }
            } else {
                if (c1 != '1' && c2 != '1') {
                    asnCount++;
                }
            }
        }
        return asnCount;
    }

    public static String formatStr(String a) {
        StringBuilder resStr = new StringBuilder();
        for (int i = 0; i < 31 - a.length(); i++) {
            resStr.append("0");
        }
        resStr.append(a);
        return resStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(minFlips(1, 2, 3));
    }
}
