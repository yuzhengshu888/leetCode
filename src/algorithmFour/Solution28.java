package algorithmFour;

import common.MyUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author yuzhengshu
 * @description:
 * @date 2021/8/1 13:34
 */
public class Solution28 {
    public static int[] kWeakestRows(int[][] mat, int k) {
        HashSet<Integer> addedSet = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                if (!addedSet.contains(i) && mat[i][j] == 0) {
                    list.add(i);
                    addedSet.add(i);
                }
                if (list.size() >= k) {
                    return list.stream().mapToInt(Integer::valueOf).toArray();
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            if (!addedSet.contains(i)) {
                list.add(i);
                addedSet.add(i);
            }
            if (list.size() >= k) {
                return list.stream().mapToInt(Integer::valueOf).toArray();
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int k = 1;
        int[][] nums = MyUtil.castToNums2("[[1,1,1,1,1],[1,1,1,1,0]]");
        System.out.println(Arrays.toString(kWeakestRows(nums, k)));
    }
}
