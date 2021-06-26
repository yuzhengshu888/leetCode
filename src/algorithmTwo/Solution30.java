package algorithmTwo;

import common.MyUtil;

import java.util.*;

//773. 滑动谜题
public class Solution30 {
    public int slidingPuzzle(int[][] board) {
        if (board[0][0] == 1
                && board[0][1] == 2
                && board[0][2] == 3
                && board[1][0] == 4
                && board[1][1] == 5
                && board[1][2] == 0) {
            return 0;
        }
        int step = 0;
        Deque<Integer[][]> deque = new LinkedList<>();
        Integer[][] first = new Integer[2][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                first[i][j] = board[i][j];
            }
        }
        deque.addLast(first);
        HashSet<String> visitSet = new HashSet<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            step++;
            for (int k = 0; k < size; k++) {
                Integer[][] poll = deque.poll();
                //确定0的位置
                int i = 0;
                int j = 0;
                for (int m = 0; m < 2; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (poll[m][n] == 0) {
                            i = m;
                            j = n;
                            break;
                        }
                    }
                }
                //向上
                if (i == 1) {
                    Integer[][] temp = copyInt(poll);
                    temp[i][j] = temp[i - 1][j];
                    temp[i - 1][j] = 0;
                    if (checkAnswer(temp, visitSet, deque, temp)) {
                        return step;
                    }
                }
                //向下
                else {
                    Integer[][] temp = copyInt(poll);
                    temp[i][j] = temp[i + 1][j];
                    temp[i + 1][j] = 0;
                    if (checkAnswer(temp, visitSet, deque, temp)) {
                        return step;
                    }
                }
                //向左
                if (j >= 1) {
                    Integer[][] temp = copyInt(poll);
                    temp[i][j] = temp[i][j - 1];
                    temp[i][j - 1] = 0;
                    if (checkAnswer(temp, visitSet, deque, temp)) {
                        return step;
                    }
                }
                //向右
                if (j <= 1) {
                    Integer[][] temp = copyInt(poll);
                    temp[i][j] = temp[i][j + 1];
                    temp[i][j + 1] = 0;
                    if (checkAnswer(temp, visitSet, deque, temp)) {
                        return step;
                    }
                }
            }
        }
        return -1;
    }

    public boolean checkAnswer(Integer[][] answer, HashSet<String> visitSet, Deque<Integer[][]> deque, Integer[][] temp) {
        boolean isRight = answer[0][0] == 1
                && answer[0][1] == 2
                && answer[0][2] == 3
                && answer[1][0] == 4
                && answer[1][1] == 5
                && answer[1][2] == 0;
        if (isRight) {
            return true;
        }
        String s = Arrays.deepToString(temp);
        boolean contains = visitSet.contains(s);
        if (!contains) {
            visitSet.add(s);
            deque.add(temp);
        }
        return false;
    }

    public Integer[][] copyInt(Integer[][] target) {
        Integer[][] newNums = new Integer[2][3];
        for (int i = 0; i < target.length; i++) {
            System.arraycopy(target[i], 0, newNums[i], 0, target[0].length);
        }
        return newNums;
    }


    //优化之后的
    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle1(int[][] board) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                sb.append(board[i][j]);
            }
        }
        String initial = sb.toString();
        if ("123450".equals(initial)) {
            return 0;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(initial);
        Set<String> seen = new HashSet<String>();
        seen.add(initial);

        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String status = queue.poll();
                for (String nextStatus : get(status)) {
                    if (!seen.contains(nextStatus)) {
                        if ("123450".equals(nextStatus)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }

        return -1;
    }

    // 枚举 status 通过一次交换操作得到的状态
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        int x = status.indexOf('0');
        for (int y : neighbors[x]) {
            swap(array, x, y);
            ret.add(new String(array));
            swap(array, x, y);
        }
        return ret;
    }

    public void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }


    public static void main(String[] args) {
        String s = MyUtil.castNums("[[1,2,3],[4,5,0]]");
        System.out.println(s);
        int[][] nums = {{1, 2, 3}, {4, 5, 0}};
        System.out.println(new Solution30().slidingPuzzle(nums));
    }
}
