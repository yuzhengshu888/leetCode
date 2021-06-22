package algorithmTwo;

import java.util.*;

/**
 * @description: 38. 字符串的排列
 * @Author: yuzhengshu
 * @Date: 2021年6月22日 09:33
 */
public class Solution20 {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        List<String> candidateList = new ArrayList<>(chars.length);
        for (char aChar : chars) {
            candidateList.add(String.valueOf(aChar));
        }
        Set<String> dfs = dfs("", candidateList);

        return dfs.toArray(new String[0]);
    }

    public Set<String> dfs(String previous, List<String> candidateList) {
        Set<String> res = new HashSet<>();
        if (candidateList.size() == 0) {
            res.add(previous);
            return res;
        }
        for (int i = 0; i < candidateList.size(); i++) {
            if (!res.contains(previous)) {
                String s = previous + candidateList.get(i);
                List<String> newList = new ArrayList<>(candidateList);
                newList.remove(i);
                Set<String> dfs = dfs(s, newList);
                res.addAll(dfs);
            }
        }
        return res;
    }

    List<String> rec = new ArrayList<>();
    boolean[] vis = new boolean[8];

    public String[] permutation1(String s) {
        char[] arr = s.toCharArray();
        //这里先排序,让所有重复的元素变得相邻
        Arrays.sort(arr);
        backtrack(arr, 0, s.length(), new StringBuffer());
        return rec.toArray(new String[0]);
    }

    public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        if (i == n) {
            rec.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            boolean b = j > 0 && !vis[j - 1] && arr[j - 1] == arr[j];
            //  解释b:
            // 在上面已经排序完成后,我们可以得到像abbc 这样的字符串
            // 在第一个选a后 ,第二个选b的结果有两条,但是得到的都是ab,所以可以直接跳过第二b
            if (vis[j] || b) {
                continue;
            }
            vis[j] = true;
            perm.append(arr[j]);
            backtrack(arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }
    }


    public static void main(String[] args) {
        String str = "aab";
        System.out.println(Arrays.toString(new Solution20().permutation(str)));
    }
}
