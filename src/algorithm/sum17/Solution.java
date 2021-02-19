package algorithm.sum17;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2020/12/24 18:04
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 *  示例 1：
 *
 * 输入：[1,0,2]
 * 输出：5
 * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 *
 * 输入：[1,2,2]
 * 输出：4
 * 解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路,如果一个连续递增的序列 ,那么分发的糖果有唯一解,即 1,2,3,4,...
 * 从正向和逆向分别求这样的唯一解
 * 在唯一解中取更大的值(更大的值必定满足条件
 */
public class Solution {

    public static int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int[] result1 = new int[ratings.length];
        int[] result2 = new int[ratings.length];
        result1[0] = 1;
        result2[ratings.length - 1] = 1;
        for (int i = 1; i < ratings.length; i++) {
            int current = ratings[i];
            int before = ratings[i - 1];
            int num = result1[i - 1];
            if (current > before) {
                result1[i] = num + 1;
            } else {
                result1[i] = 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            int current = ratings[i];
            int before = ratings[i - 1];
            int num = result2[i];
            if (current < before) {
                result2[i - 1] = num + 1;
            } else {
                result2[i - 1] = 1;
            }
        }
        int resultSum = 0;
        for (int i = 0; i < ratings.length; i++) {
            resultSum += Math.max(result1[i], result2[i]);
        }
        return resultSum;
    }

    public static void main(String[] args) {
        int[] ratings = new int[]{
                1, 0, 2
        };
        System.out.println("5" + " " + candy(ratings));

        int[] ratings1 = new int[]{
                1, 2, 2
        };
        System.out.println("4" + " " + candy(ratings1));

        int[] ratings2 = new int[]{
                1, 3, 2, 2, 1
        };
        System.out.println("7" + " " + candy(ratings2));

        int[] ratings3 = new int[]{
                1, 2, 3, 1, 0
        };
        System.out.println("9" + " " + candy(ratings3));
    }
}
