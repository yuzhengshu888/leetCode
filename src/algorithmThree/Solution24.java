package algorithmThree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//1711. 大餐计数
public class Solution24 {
    public static int countPairs(int[] deliciousness) {
        HashMap<Integer, Long> map = new HashMap<>();
        final int mod = 1000000007;
        for (int i : deliciousness) {
            map.merge(i, 1l, Long::sum);
        }
        long asnCount = 0;
        Iterator<Map.Entry<Integer, Long>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Long> entry = iterator.next();
            int sumValue = 1;
            Integer key = entry.getKey();
            Long value = entry.getValue();
            for (int i = 0; i < 22; i++) {
                int searchKey = sumValue - key;
                Long searchValue = map.get(searchKey);
                if (searchValue != null) {
                    if (searchKey == key) {
                        long a = (value * (value - 1) / 2) % mod;
                        asnCount = (asnCount + a) % mod;
                    } else {
                        asnCount = asnCount + (searchValue * value) % mod;
                    }
                }
                sumValue = sumValue << 1;
            }
            iterator.remove();
        }
        return (int) asnCount;
    }

    public static void main(String[] args) {
        int[] nums = new int[100000];
        for (int i = 0; i < 100000; i++) {
            nums[i] = 32;
        }
        System.out.println(countPairs(nums));
    }
}
