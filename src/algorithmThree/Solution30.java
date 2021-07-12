package algorithmThree;

import java.util.ArrayList;
import java.util.List;

//77. 组合
public class Solution30 {
    public List<List<Integer>> combine(int n, int k) {
        int[] beSelected = new int[n];
        for (int i = 0; i < n; i++) {
            beSelected[i] = i + 1;
        }
        return dfs(new ArrayList<>(), beSelected, k, 0);
    }

    public List<List<Integer>> dfs(List<Integer> current, int[] beSelected, int maxSize, int index) {
        List<List<Integer>> res = new ArrayList<>();
        if (current.size() + beSelected.length - index < maxSize) {
            return null;
        }
        if (current.size() >= maxSize) {
            List<Integer> addList = new ArrayList<>(current.size());
            addList.addAll(current);
            res.add(addList);
            return res;
        }
        for (int i = index; i < beSelected.length; i++) {
            if (beSelected[i] == 0) {
                continue;
            }
            List<Integer> addList = new ArrayList<>(current.size());
            addList.addAll(current);
            addList.add(beSelected[i]);
            List<List<Integer>> dfs = dfs(addList, beSelected, maxSize, i + 1);
            if (dfs != null) {
                res.addAll(dfs);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution30 s = new Solution30();
        List<List<Integer>> combine = s.combine(4, 2);
        System.out.println(combine.toString());
    }
}
