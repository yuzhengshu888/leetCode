package algorithmThree;

import common.MyUtil;

import java.util.*;

/**
 * @description: 815. 公交路线
 * @Author: yuzhengshu
 * @Date: 2021年6月28日 09:33
 */
public class Solution1 {
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        //key:站台 value:可以换成的车
        HashMap<Integer, List<Integer>> transferToMap = new HashMap<>();
        List<Integer> targetList = new ArrayList<>();
        List<Integer> sourceList = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int j : route) {
                if (target == j) {
                    targetList.add(i);
                }
                if (source == j) {
                    sourceList.add(i);
                }
                List<Integer> orDefault = transferToMap.getOrDefault(j, new ArrayList<>());
                orDefault.add(i);
                transferToMap.put(j, orDefault);
            }
        }
        //key:当前路线 value:这条路线可以换乘的车
        HashMap<Integer, Set<Integer>> routeMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            HashSet<Integer> set = new HashSet<>();
            for (int i1 : route) {
                List<Integer> integers = transferToMap.get(i1);
                set.addAll(integers);
            }
            routeMap.put(i, set);
        }

        int step = 0;
        HashSet<Integer> visitSet = new HashSet<>();
        Deque<Integer> deque = new LinkedList<>(sourceList);
        while (!deque.isEmpty()) {
            int size = deque.size();
            step++;
            for (int i = 0; i < size; i++) {
                Integer poll = deque.poll();
                if (targetList.contains(poll)) {
                    return step;
                }
                Set<Integer> integers = routeMap.get(poll);
                for (Integer integer : integers) {
                    if (!visitSet.contains(integer)) {
                        deque.addAll(integers);
                        visitSet.addAll(integers);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = MyUtil.castNums("[[7,12],[4,5,15],[6],[15,19],[9,12,13]]");
        System.out.println(s);
        int[][] routes = {{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};
        int source = 15;
        int target = 12;
        System.out.println(numBusesToDestination(routes, source, target));
    }
}
