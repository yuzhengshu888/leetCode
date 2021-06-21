package algorithmTwo;

import java.util.*;

/**
 * @description: 401. 二进制手表
 * @Author: yuzhengshu
 * @Date: 2021年6月21日 09:12
 */
public class Solution17 {
    //4个小时,6个分钟
    //119ms
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        String ori = "0000000000";
        char changeTo = '1';
        if (turnedOn > 5) {
            ori = "1111111111";
            turnedOn = 10 - turnedOn;
            changeTo = '0';
        }
        List<String> dfs = dfs(ori, turnedOn, changeTo);
        Set<String> res1 = new HashSet<>(dfs.size());
        for (String df : dfs) {
            String hours = df.substring(0, 4);
            Integer hours1 = Integer.valueOf(hours, 2);
            String minutes = df.substring(4, 10);
            Integer minutes1 = Integer.valueOf(minutes, 2);
            if (minutes1 < 60 && hours1 < 12) {
                res1.add(hours1 + ":" + String.format("%02d", minutes1));
            }
        }
        return new ArrayList<>(res1);
    }

    public List<String> dfs(String oriString, int count, Character changeTo) {
        List<String> res = new ArrayList<>();
        count--;
        if (count < 0) {
            res.add(oriString);
            return res;
        }
        for (int i = 9; i >= 0; i--) {
            if (oriString.charAt(i) != changeTo) {
                String str = oriString.substring(0, i) + changeTo + oriString.substring(i + 1, 10);
                List<String> dfs = dfs(str, count, changeTo);
                res.addAll(dfs);
            }
        }
        return res;
    }

    /**
     * 对重复的数据进行优化
     */
    public List<String> readBinaryWatch1(int turnedOn) {
        List<String> res1 = new ArrayList<>();
        if (turnedOn == 0) {
            res1.add("0:00");
            return res1;
        }
        dfsNew("", turnedOn, res1);
        return res1;
    }


    public List<String> dfsNew(String endStr, int count, List<String> res) {
        List<String> temp = new ArrayList<>();
        if (endStr.length() + count > 10) {
            return res;
        }
        if (count <= 0) {
            String endZeroStr = String.format("%010d", Integer.valueOf(endStr));
            temp.add(endZeroStr);
            String hours = endZeroStr.substring(0, 4);
            int hours1 = Integer.valueOf(hours, 2);
            String minutes = endZeroStr.substring(4, 10);
            int minutes1 = Integer.valueOf(minutes, 2);
            if (minutes1 < 60 && hours1 < 12) {
                res.add(hours1 + ":" + (minutes1 < 10 ? "0" : "") + minutes1);
            }
            return res;
        }
        temp.addAll(dfsNew("0" + endStr, count, res));
        count = count - 1;
        temp.addAll(dfsNew("1" + endStr, count, res));
        return temp;
    }

    /**
     * 反向思考,直接将时间转换为二进制
     * 12ms
     */
    public List<String> readBinaryWatch2(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }

    /**
     * 一共最多有2^10 =1024种可能,判断这些可能性中存在的1的个数
     */
    public List<String> readBinaryWatch3(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 1024; ++i) {
            int h = i >> 6, m = i & 63; // 用位运算取出高 4 位和低 6 位
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                ans.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return ans;
    }

    /**
     * 打表法
     * 对readBinaryWatch2来说,我们不需求每次都重复计算
     */
    static Map<Integer, List<String>> map = new HashMap<>();

    static {
        for (int h = 0; h <= 11; h++) {
            for (int m = 0; m <= 59; m++) {
                int count = Integer.bitCount(h) + Integer.bitCount(m);
                String str = h + ":" + (m <= 9 ? "0" + m : m);
                List<String> orDefault = map.getOrDefault(count, new ArrayList<>());
                orDefault.add(str);
                map.put(count, orDefault);
            }
        }
    }

    public List<String> readBinaryWatch4(int t) {
        return map.getOrDefault(t, new ArrayList<>());
    }


    public static void main(String[] args) {
        System.out.println(new Solution17().readBinaryWatch1(3));
    }
}
