package algorithm.sum7;


/**
 * @description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * @Author: yuzhengshu
 * @Date: 2020/12/14 19:02
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2的31次方,  2的31次方 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 优化:如果关心效率,就不要使用字符串翻转的方法
 * 字符串翻转的方法
 * https://blog.csdn.net/eriol/article/details/83806466
 */
class Solution {
        public static int reverse(int x) {
            boolean isFu = false;
            StringBuilder str = new StringBuilder(Integer.toString(x));
            if (str.charAt(0) == '-') {
                str.deleteCharAt(0);
                isFu = true;
            }
            String s = str.reverse().toString();
            try {
                return isFu ? -Integer.parseInt(s) : Integer.parseInt(s);
            } catch (Exception e) {
                return 0;
            }
        }

    public static void main(String[] args) {
        System.out.println(reverse(-100));
    }
}
