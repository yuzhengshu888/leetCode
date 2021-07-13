package algorithmFour;

/**
 * @description: 买橘子
 * @Author: yuzhengshu
 * @Date: 2021年7月13日 18:10
 */
public class Solution4 {
    public static int buyOrange(int target) {
        int count = target / 5;
        int other = target % 5;
        if (other == 0) {
            return count;
        }
        while (other % 3 != 0) {
            other += 5;
            if (other > target) {
                return -1;
            }
            count--;
        }
        return count + other / 3;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println("" + i + ":" + buyOrange(i));
        }
    }
}
