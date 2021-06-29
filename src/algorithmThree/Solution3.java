package algorithmThree;

/**
 * @description: 168. Excel表列名称
 * @Author: yuzhengshu
 * @Date: 2021年6月29日 09:41
 */
public class Solution3 {
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().convertToTitle(2147483647));
    }
}
