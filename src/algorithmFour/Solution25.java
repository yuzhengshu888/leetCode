package algorithmFour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuzhengshu
 * @description:
 * @date 2021/7/26 16:52
 */
public class Solution25 {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> orDefault = map.getOrDefault(arr[i], new ArrayList<>());
            orDefault.add(i);
            map.put(arr[i], orDefault);
        }
        int asn = 0;
        int currentIndex = 0;
        for (int i = 0; i < target.length; i++) {
            if (map.get(target[i]) == null) {
                asn++;
            }

        }
        return asn;
    }
}
