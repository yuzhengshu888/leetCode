package algorithmFour;

import common.MyUtil;

import java.util.*;

/**
 * @description: 218. 天际线问题
 * @Author: yuzhengshu
 * @Date: 2021年7月13日 10:58
 */
public class Solution2 {

    static class NodeEntry {
        boolean isLeftNode;
        int index;
        int height;

        public NodeEntry(boolean isLeftNode, int index, int height) {
            this.isLeftNode = isLeftNode;
            this.index = index;
            this.height = height;
        }
    }

    //使用扫描线，从左至右扫过。如果遇到左端点，将高度入堆，如果遇到右端点，则将高度从堆中删除。使用 last 变量记录上一个转折点。
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        int lastHeight = 0;
        List<List<Integer>> asnList = new ArrayList<>();
        PriorityQueue<Integer> heightQueue = new PriorityQueue<>((x, y) -> y - x);
        ArrayList<NodeEntry> endpointList = new ArrayList<>();
        for (int[] building : buildings) {
            endpointList.add(new NodeEntry(true, building[0], building[2]));
            endpointList.add(new NodeEntry(false, building[1], building[2]));
        }
        endpointList.sort(Comparator.comparingInt(x -> x.index));
        for (int i = 0; i < endpointList.size(); i++) {
            NodeEntry nodeEntry = endpointList.get(i);
            if (nodeEntry.isLeftNode) {
                heightQueue.offer(nodeEntry.height);
            } else {
                heightQueue.remove(nodeEntry.height);
            }
            int j = i + 1;
            while (j < endpointList.size() && endpointList.get(j).index == nodeEntry.index) {
                NodeEntry entry = endpointList.get(j);
                if (entry.isLeftNode) {
                    heightQueue.offer(entry.height);
                } else {
                    heightQueue.remove(entry.height);
                }
                j++;
            }
            i = j - 1;
            if (heightQueue.isEmpty()) {
                lastHeight = 0;
                asnList.add(Arrays.asList(nodeEntry.index, 0));
            }
            if (!heightQueue.isEmpty() && lastHeight != heightQueue.peek()) {
                lastHeight = heightQueue.peek();
                asnList.add(Arrays.asList(nodeEntry.index, lastHeight));
            }
        }
        return asnList;
    }

    public static void main(String[] args) {
        int[][] ints = MyUtil.castToNums2("[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]");
        List<List<Integer>> skyline = getSkyline(ints);
        System.out.println(skyline);
    }
}
