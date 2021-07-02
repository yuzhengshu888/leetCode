package algorithmThree;

/**
 * @description: 704. 二分查找
 * @Author: yuzhengshu
 * @Date: 2021年7月2日 16:03
 */
public class Solution16 {
    public int search(int[] nums, int target) {
        return dfs(nums, target, 0, nums.length - 1);
    }

    public int dfs(int[] nums, int target, int left, int right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (left == right) {
            return -1;
        }
        if (nums[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        if (left > right) {
            return -1;
        }
        return dfs(nums, target, left, right);
    }

    public int search1(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }
            if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int target = 0;
        int[] nums = {2};
        System.out.println(new Solution16().search(nums, target));
    }
}
