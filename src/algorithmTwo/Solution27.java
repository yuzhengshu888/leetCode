package algorithmTwo;

import java.util.*;

//752. 打开转盘锁
public class Solution27 {
    int step = 0;
    HashSet<String> deadSet = new HashSet<>();
    public int openLock(String[] deadends, String target) {
        deadSet.addAll(Arrays.asList(deadends));
        if (deadSet.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        set.add("0000");
        Set<String> bfsList = bfs(set, target);
        int size = 0;
        while (bfsList != null) {
            size = bfsList.size();
            bfsList = bfs(bfsList, target);
            if (bfsList != null && bfsList.size() <= size) {
                return -1;
            }
        }
        return step;
    }

    public Set<String> bfs(Set<String> list, String target) {
        Set<String> res = new HashSet<>();
        step++;
        for (String node : list) {
            for (int i = 0; i < 4; i++) {
                StringBuilder temp1 = new StringBuilder(node);
                char c = node.charAt(i);
                temp1.setCharAt(i, addOne(c));
                String s1 = temp1.toString();
                if (s1.equals(target)) {
                    return null;
                }
                StringBuilder temp2 = new StringBuilder(node);
                temp2.setCharAt(i, subOne(c));
                String s2 = temp2.toString();
                if (s2.equals(target)) {
                    return null;
                }
                if (!deadSet.contains(s1)) {
                    res.add(s1);
                }
                if (!deadSet.contains(s2)) {
                    res.add(s2);
                }
            }
        }
        if (res.size() == 0) {
            step = -1;
        }
        return res;
    }

    public char addOne(char aChar) {
        if (aChar == '9') {
            return '0';
        }
        return (char) (aChar + 1);
    }

    public char subOne(char aChar) {
        if (aChar == '0') {
            return '9';
        }
        return (char) (aChar - 1);
    }

    public int openLock1(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visit = new HashSet<>();
        visit.add("0000");
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (deads.contains(cur)) continue;
                if (target.equals(cur)) return ans;
                for (int j = 0; j < 4; j++) {
                    String up = plusUp(cur, j);
                    if (!visit.contains(up)) {
                        queue.offer(up);
                        visit.add(up);
                    }
                    String down = plusDawn(cur, j);
                    if (!visit.contains(down)) {
                        queue.offer(down);
                        visit.add(down);
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    public String plusUp(String s, int i) {
        char[] arr = s.toCharArray();
        if (arr[i] == '9') arr[i] = '0';
        else arr[i] += 1;
        return new String(arr);
    }

    public String plusDawn(String s, int i) {
        char[] arr = s.toCharArray();
        if (arr[i] == '0') arr[i] = '9';
        else arr[i] -= 1;
        return new String(arr);
    }


    public static void main(String[] args) {
        String target = "8888";
        String[] deadList = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
//        target = "0202";
//        deadList = new String[]{"1000", "0100", "0010", "0001", "9000", "0900", "0090", "0009"};
        System.out.println(new Solution27().openLock(deadList, target));
    }
}
