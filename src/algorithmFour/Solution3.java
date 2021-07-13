package algorithmFour;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: test1
 * @Author: yuzhengshu
 * @Date: 2021年7月13日 16:33
 */
public class Solution3 {
    int count = 0;
    int[] nums;
    int sum;
    int[] prefixSum;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> calculateCount(int[] nums) {
        this.nums = nums;
        this.prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i + 1] = sum;
        }
        dfs(new ArrayList<>(), 0, 10, 0);
        return res;
    }

    public void dfs(List<Integer> list, int currentSum, int min, int index) {
        if (sum < (2 * currentSum) && (2 * currentSum) < (sum + min * 2)) {
            res.add(new ArrayList<>(list));
            return;
        }
        //剪枝 如果剩下的加起来还不能满足条件就放弃
        if (index >= 1 && (sum - prefixSum[index] + currentSum) * 2 < sum) {
            return;
        }
        if (index >= nums.length) {
            return;
        }
        int num = nums[index];
        //不选这个人
        dfs(list, currentSum, min, index + 1);
        //选这个人
        list.add(num);
        dfs(list, currentSum + num, Math.min(min, num), index + 1);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 4};
        System.out.println(new Solution3().calculateCount(nums));
    }
}
