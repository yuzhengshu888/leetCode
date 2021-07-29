package algorithmFour;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuzhengshu
 * @description: 1104. 二叉树寻路
 * @date 2021/7/29 10:55
 */
public class Solution27 {
    ArrayList<Integer> resList = new ArrayList<>();

    public List<Integer> pathInZigZagTree(int label) {
        int level = 0, nextAdd = 1, sum = 0;
        while (label > sum) {
            sum = sum + nextAdd;
            nextAdd = nextAdd * 2;
            level++;
        }
        dfs(level, label, sum - nextAdd / 2, nextAdd / 2);
        return resList;
    }

    public void dfs(int level, int label, int sum, int lastAdd) {
        if (level <= 0) {
            return;
        }
        resList.add(0, label);
        int lastLabel = 0;
        int temp = (int) Math.ceil((double) (label - sum) / 2);
        if (level / 2 == 0) {
            lastLabel = temp;
        } else {
            lastLabel = sum - temp + 1;
        }
        dfs(level - 1, lastLabel, sum - lastAdd / 2, lastAdd / 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution27().pathInZigZagTree(1));
    }
}
