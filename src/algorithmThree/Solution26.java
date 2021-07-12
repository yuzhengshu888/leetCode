package algorithmThree;

import java.util.HashMap;

/**
 * @Description: 274. H 指数 I
 * @Author: yuzhengshu
 * @Date: 2021年7月12日
 */
public class Solution26 {
    public static int hIndex(int[] citations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = citations.length;
        for (int citation : citations) {
            map.merge(Math.min(citation, length), 1, Integer::sum);
        }

        int sum = 0;
        int hIndex = 0;
        for (int i = length; i > 0; i--) {
            Integer reference = map.get(i);
            if (reference == null) {
                if (sum >= i) {
                    return i;
                }
                continue;
            }
            sum += reference;
            if (sum >= i) {
                return i;
            }
        }
        return hIndex;
    }

    public static void main(String[] args) {
        int[] nums = {11,15};
        System.out.println(hIndex(nums));
    }
}
