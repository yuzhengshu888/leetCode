package algorithmThree;

import java.util.*;

/**
 * @description: 1560. 圆形赛道上经过次数最多的扇区
 * @Author: yuzhengshu
 * @Date: 2021年6月30日 17:32
 */
public class Solution9 {
    public static List<Integer> mostVisited(int n, int[] rounds) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        int round = rounds[0];
        for (int i = round; i <= n; i++) {
            set.add(i);
        }
        int round1 = rounds[rounds.length - 1];
        for (int i = 1; i <= round1; i++) {
            if (set.contains(i)) {
                res.add(i);
            }
            set.add(i);
        }
        if (res.size() == 0) {
            ArrayList<Integer> integers = new ArrayList<>(set);
            integers.sort(Comparator.comparingInt(x -> x));
            return integers;
        }
        return res;
    }

    public List<Integer> mostVisited1(int n, int[] rounds) {
        List<Integer> ret = new ArrayList<Integer>();
        int length = rounds.length;
        int start = rounds[0], end = rounds[length - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                ret.add(i);
            }
        } else { // 由于题目要求按扇区大小排序，因此我们要将区间分成两部分
            for (int i = 1; i <= end; i++) {
                ret.add(i);
            }
            for (int i = start; i <= n; i++) {
                ret.add(i);
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = {16, 8};
        int n = 17;
        System.out.println(mostVisited(n, nums));
    }
}
