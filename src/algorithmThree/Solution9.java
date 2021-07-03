package algorithmThree;

import java.util.Arrays;

public class Solution9 {
    public static int[] sortedSquares(int[] nums) {
        Integer zeroIndex = null;
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                zeroIndex = i;
                break;
            }
        }
        if (zeroIndex == null) {
            if (nums[0] > 0) {
                right = 0;
                left = -1;
            } else {
                left = nums.length - 1;
                right = nums.length + 1;
            }
        } else {
            left = zeroIndex - 1;
            right = zeroIndex;
        }
        int[] asn = new int[nums.length];
        int i = 0;
        while (right < nums.length || left > -1) {
            int numLeft = left > -1 ? -nums[left] : Integer.MAX_VALUE;
            int numRight = right < nums.length ? nums[right] : Integer.MAX_VALUE;
            if (numLeft <= numRight) {
                asn[i] = numLeft * numLeft;
                left--;
            } else {
                asn[i] = numRight * numRight;
                right++;
            }
            i++;
        }
        return asn;
    }

    public int[] sortedSquares1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {-5, -3, -2, -1};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
