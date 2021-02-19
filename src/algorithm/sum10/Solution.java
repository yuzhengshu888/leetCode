package algorithm.sum10;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2020/12/15 16:43
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static int monotoneIncreasingDigits(int N) {
        //第一个转折处减1,后面全加9
        //问题就变成找第一个转折处
        if (N < 10) {
            return N;
        }
        char[] chars = String.valueOf(N).toCharArray();
        StringBuilder temp = new StringBuilder();
        Integer breakNode = null;
        for (int i = 0; i < chars.length - 1; i++) {
            char currentNum = chars[i];
            char nextNum = chars[i + 1];
            if (nextNum < currentNum) {
                breakNode = i;
                break;
            }
        }
        if (breakNode != null) {
            for (int i = breakNode; i - 1 >= 0; i--) {
                char currentNum = chars[i];
                char beforeNum = chars[i - 1];
                if (currentNum - 1 < beforeNum) {
                    breakNode = i - 1;
                }else {
                    break;
                }
            }
        } else {
            return N;
        }
        for (int i = 0; i < chars.length - 1; i++) {
            int num = Integer.parseInt(String.valueOf(chars[i]));
            if (i < breakNode) {
                temp.append(num);
            } else if (i == breakNode) {
                temp.append(num - 1);
            } else {
                temp.append(9);
            }
        }
        temp.append(9);
        return Integer.parseInt(temp.toString());
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(668841));
    }
}
