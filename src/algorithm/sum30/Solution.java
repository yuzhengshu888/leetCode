package algorithm.sum30;

/**
 * @description: 12. 整数转罗马数字
 * @Author: yuzhengshu
 * @Date: 2021/5/14 15:10
 */
public class Solution {
    /**
     * 法1,憨批解法
     */
    public static String intToRoman(int num) {
        String s1 = "", s2 = "", s3 = "", s4 = "";
        //个位
        int d = num % 10;
        num = num / 10;
        s1 = switchStr(d, "I", "V", "X");
        //十位
        if (num > 0) {
            int c = num % 10;
            num = num / 10;
            s2 = switchStr(c, "X", "L", "C");
        }
        if (num > 0) {
            int b = num % 10;
            num = num / 10;
            s3 = switchStr(b, "C", "D", "M");
        }
        if (num > 0) {
            s4 = switchStr(num, "M", "", "");
        }
        return s4 + s3 + s2 + s1;
    }

    static String switchStr(int i, String num1, String num2, String num3) {
        switch (i) {
            case 1:
                return num1;
            case 2:
                return num1 + num1;
            case 3:
                return num1 + num1 + num1;
            case 4:
                return num1 + num2;
            case 5:
                return num2;
            case 6:
                return num2 + num1;
            case 7:
                return num2 + num1 + num1;
            case 8:
                return num2 + num1 + num1 + num1;
            case 9:
                return num1 + num3;
            default:
                return "";
        }
    }


    /**
     * 优化后的法1
     */
    static String[] thousands = {"", "M", "MM", "MMM"};
    static String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    static String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    static String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public static String intToRoman1(int num) {
        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }

    /**
     * 最优解法
     */
    public String intToRoman2(int num) {
        // 定义输出字符串
        StringBuilder str = new StringBuilder();

        //循环储存字符
        while (num > 0) {
            if (num >= 1000) {
                str.append("M");
                num = num - 1000;
            } else if (num >= 900) {
                str.append("CM");
                num = num - 900;
            } else if (num >= 500) {
                str.append("D");
                num = num - 500;
            } else if (num >= 400) {
                str.append("CD");
                num = num - 400;
            } else if (num >= 100) {
                str.append("C");
                num = num - 100;
            } else if (num >= 90) {
                str.append("XC");
                num = num - 90;
            } else if (num >= 50) {
                str.append("L");
                num = num - 50;
            } else if (num >= 40) {
                str.append("XL");
                num = num - 40;
            } else if (num >= 10) {
                str.append("X");
                num = num - 10;
            } else if (num >= 9) {
                str.append("IX");
                num = num - 9;
            } else if (num >= 5) {
                str.append("V");
                num = num - 5;
            } else if (num >= 4) {
                str.append("IV");
                num = num - 4;
            } else if (num >= 1) {
                str.append("I");
                num = num - 1;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(10));
    }
}
