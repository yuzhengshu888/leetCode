package algorithmFour;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuzhengshu
 * @description: 89. 格雷编码
 * @date 2021/7/19 12:19
 */
public class Solution11 {
    /*
     * @Description 找规律
     * @Author yuzhengshu
     * @Date 2021/7/19
     **/
    // 0 1   2   3
    // 0 0  00  000
    //   1  01  001
    //      11  011
    //      10  010
    //          110
    //          111
    //          101
    //          100
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }
}
