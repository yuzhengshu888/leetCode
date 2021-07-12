package algorithmThree;

/**
 * @description: 275. H 指数 II
 * @Author: yuzhengshu
 * @Date: 2021年7月12日 11:03
 */
//h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）
// 总共有 h 篇论文分别被引用了至少 h 次。（其余的n-h篇论文每篇被引用次数不多于 h 次。）"
public class Solution27 {
    public static int hIndex(int[] citations) {
        int asn = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] <= asn) {
                return asn;
            }
            asn++;
        }
        return asn;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1};
        System.out.println(hIndex(nums));
    }
}
