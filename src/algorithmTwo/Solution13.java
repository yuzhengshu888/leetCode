package algorithmTwo;

import java.util.*;

/**
 * @description: 223. 矩形面积
 * @Author: yuzhengshu
 * @Date: 2021年6月18日 15:58
 */
public class Solution13 {
    static class Flag {
        String flag;
        int value;

        public Flag(String a, int ax1) {
            flag = a;
            value = ax1;
        }
    }

    //                     左下x1     左下y1  右上x2    右上y2    左下x1     左下y1  右上x2    右上y2
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int sum1 = (ax2 - ax1) * (ay2 - ay1);
        int sum2 = (bx2 - bx1) * (by2 - by1);
        int common;

        List<Flag> xList = new ArrayList<>(4);
        xList.add(new Flag("a", ax1));
        xList.add(new Flag("a", ax2));
        xList.add(new Flag("b", bx1));
        xList.add(new Flag("b", bx2));
        xList.sort(Comparator.comparingInt(x -> x.value));
        if (xList.get(0).flag.equals(xList.get(1).flag)) {
            return sum1 + sum2;
        }
        List<Flag> yList = new ArrayList<>(4);
        yList.add(new Flag("a", ay1));
        yList.add(new Flag("a", ay2));
        yList.add(new Flag("b", by1));
        yList.add(new Flag("b", by2));
        yList.sort(Comparator.comparingInt(x -> x.value));
        if (yList.get(0).flag.equals(yList.get(1).flag)) {
            return sum1 + sum2;
        }
        common = (xList.get(2).value - xList.get(1).value) * (yList.get(2).value - yList.get(1).value);
        return sum1 + sum2 - common;
    }

    public int computeArea1(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int sum1 = (ax2 - ax1) * (ay2 - ay1);
        int sum2 = (bx2 - bx1) * (by2 - by1);
        //计算相交的部分形成的长方形的高度width
        int widthy1 = Math.max(ay1, by1);
        int widthy2 = Math.min(ay2, by2);
        // b1b2a1a2 排除
        //
        // b1a1 b2a2
        // b1a1 a2b2
        // a1b1 b2a2
        // a1b1 a2b2
        //
        // a1a2b1b2 排除
        //不相交
        if (widthy1 >= widthy2) {
            return sum1 + sum2;
        }
        //计算相交部分的长方形的宽度length
        int lenthg1 = Math.max(ax1, bx1);
        int lenthg2 = Math.min(ax2, bx2);
        //不相交
        if (lenthg1 >= lenthg2) {
            return sum1 + sum2;
        }
        int width = widthy2 - widthy1;
        int length = lenthg2 - lenthg1;
        int subarea = width * length;
        return sum1 + sum2 - subarea;
    }

}
