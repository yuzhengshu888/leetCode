package algorithmTwo;

import java.util.HashMap;

/**
 * @description: 149. 直线上最多的点数
 * @Author: yuzhengshu
 * @Date: 2021年6月24日 09:12
 */
public class Solution26 {
    public static int maxPoints(int[][] points) {
        int length = points.length;
        //在点的总数量小于等于 2 的情况下，我们总可以用一条直线将所有点串联，此时我们直接返回点的总数量即可；
        if (length <= 2) {
            return length;
        }
        int maxCount = 1;
        for (int i = 0; i < length; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            HashMap<Double, Integer> map = new HashMap<>();
            //当我们枚举到点 ii 时，我们只需要考虑编号大于 ii 的点到点 ii 的斜率，因为如果直线同时经过编号小于点 ii 的点 jj，那么当我们枚举到 jj 时就已经考虑过该直线了；
            for (int j = i + 1; j < length; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                double v1 = y2 - y1;
                double v2 = x2 - x1;
                double k;
                if (v1 == 0) {
                    k = 0;
                } else if (v2 == 0) {
                    k = Double.POSITIVE_INFINITY;
                } else {
                    k = v1 / v2;
                }
                //这里使用除法会有精度的问题 float的精度为7位,double的精度为15位
                Integer orDefault = map.getOrDefault(k, 1);
                int i1 = orDefault + 1;
                maxCount = Math.max(maxCount, i1);
                map.put(k, i1);
            }
            //当我们枚举到点 i（假设编号从 0 开始）时，我们至多只能找到 length - i 个点共线。
            //假设此前找到的共线的点的数量的最大值为 maxCount
            //如果有 maxCount ≥ length−i，那么此时我们即可停止枚举，因为不可能再找到更大的答案了。
            if (maxCount > length - i) {
                return maxCount;
            }
            //优化点:当我们找到一条直线经过了图中超过半数的点时，我们即可以确定该直线即为经过最多点的直线；
            if (maxCount > (length / 2)) {
                return maxCount;
            }
        }
        return maxCount;
    }

    public int maxPoints1(int[][] ps) {
        int n = ps.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int[] x = ps[i];
            for (int j = i + 1; j < n; j++) {
                int[] y = ps[j];
                int cnt = 2;
                for (int k = j + 1; k < n; k++) {
                    int[] p = ps[k];
                    int s1 = (y[1] - x[1]) * (p[0] - y[0]);
                    int s2 = (p[1] - y[1]) * (y[0] - x[0]);
                    if (s1 == s2) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String str = "[[0,1],[0,0],[0,4],[0,-2],[0,-1],[0,3],[0,-4]]";
        String replace = str.replace("]", "}").replace("[", "{");
        System.out.println(replace);
        int[][] points = {{0, 1}, {0, 0}, {0, 4}, {0, -2}, {0, -1}, {0, 3}, {0, -4}};
        System.out.println(maxPoints(points));
    }
}
