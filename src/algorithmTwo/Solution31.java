package algorithmTwo;

import common.MyUtil;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

//909. 蛇梯棋
public class Solution31 {
    public int snakesAndLadders(int[][] board) {
        int step = 0;
        int height = board.length;
        int target = height * height;
        HashSet<Integer> set = new HashSet<>();
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        while (!deque.isEmpty()) {
            int size = deque.size();
            step++;
            for (int i = 0; i < size; i++) {
                Integer poll = deque.poll();
                for (int nextValue = poll + 1; nextValue <= poll + 6; nextValue++) {

                    int r = (nextValue - 1) / height, index = (nextValue - 1) % height;
                    if (r % 2 == 1) {
                        index = height - 1 - index;
                    }
                    int level = height - 1 - r;
                    int tempValue = board[level][index] == -1 ? nextValue : board[level][index];
                    if (tempValue == target || nextValue == target) {
                        return step;
                    }
                    if (!set.contains(tempValue)) {
                        set.add(tempValue);
                        deque.addLast(tempValue);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = MyUtil.castNums("[[-1,-1,2,21,-1],[16,-1,24,-1,4],[2,3,-1,-1,-1],[-1,11,23,18,-1],[-1,-1,-1,23,-1]]");
        System.out.println(s);
        int[][] nums = {{-1, -1, 2, 21, -1}, {16, -1, 24, -1, 4}, {2, 3, -1, -1, -1}, {-1, 11, 23, 18, -1}, {-1, -1, -1, 23, -1}};
//        nums = new int[][]{{-1, -1}, {-1, 3}};
        System.out.println(new Solution31().snakesAndLadders(nums));
    }

}
