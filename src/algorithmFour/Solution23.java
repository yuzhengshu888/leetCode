package algorithmFour;

/**
 * @author yuzhengshu
 * @description: 1736. 替换隐藏数字得到的最晚时间
 * @date 2021/7/24 20:17
 */
public class Solution23 {
    public static String maximumTime(String time) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = time.toCharArray();
        char aChar1 = chars[0];
        char aChar2 = chars[1];
        char aChar3 = chars[3];
        char aChar4 = chars[4];
        if (aChar1 == '?') {
            if (aChar2 == '?' || aChar2 < '4') {
                stringBuilder.append("2");
            } else {
                stringBuilder.append("1");
            }
        } else {
            stringBuilder.append(aChar1);
        }
        if (aChar2 == '?') {
            if (stringBuilder.charAt(0) == '2') {
                stringBuilder.append("3");
            } else {
                stringBuilder.append("9");
            }
        } else {
            stringBuilder.append(aChar2);
        }
        stringBuilder.append(":");
        if (aChar3 == '?') {
            stringBuilder.append("5");
        } else {
            stringBuilder.append(aChar3);
        }
        if (aChar4 == '?') {
            stringBuilder.append("9");
        } else {
            stringBuilder.append(aChar4);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "1?:22";
        System.out.println(maximumTime(str));
    }
}
