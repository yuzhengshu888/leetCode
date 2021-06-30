package algorithmThree;

import java.util.*;

/**
 * @description: 该马拉松全程由
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

    public static void main(String[] args) {
        int[] nums = {16, 8};
        int n = 17;
        System.out.println(mostVisited(n, nums));
    }
}
