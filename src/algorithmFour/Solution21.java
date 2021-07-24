package algorithmFour;

/**
 * @author yuzhengshu
 * @description:
 * @date 2021/7/21 20:42
 */
public class Solution21 {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        int[] nums = new int[128];
        int asn = 0;
        while (right < s.length()) {
            if (nums[chars[right]] >= left) {
                left = nums[chars[right]] + 1; 
            }
            nums[chars[right]] = right;
            asn = Math.max(asn, right - left + 1);
            right++;
        }
        return asn;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
