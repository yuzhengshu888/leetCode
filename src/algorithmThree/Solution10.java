package algorithmThree;

import java.io.*;
import java.util.*;

/**
 * @description: 1488. 避免洪水泛滥
 * @Author: yuzhengshu
 * @Date: 2021年6月30日 18:03
 */
public class Solution10 {
    public static int[] avoidFlood(int[] rains) {
        //记录下雨的湖
        ArrayList<Integer> willRainList = new ArrayList<>();
        for (int rain : rains) {
            if (rain != 0) {
                willRainList.add(rain);
            }
        }
        //记录已经满水的湖
        HashSet<Integer> rainedSet = new HashSet<>();
        //如果遇到晴天,抽之后会第一个下雨的第一个满水湖
        int[] res = new int[rains.length];
        int index = 0;
        for (int i = 0; i < rains.length; i++) {
            int rainDay = rains[i];
            if (rainDay == 0) {
                //抽水
                int pumpingLake = 1;
                for (int i1 = index; i1 < willRainList.size(); i1++) {
                    int willRainLake = willRainList.get(i1);
                    if (rainedSet.contains(willRainLake)) {
                        pumpingLake = willRainLake;
                        rainedSet.remove(pumpingLake);
                        break;
                    }
                }
                res[i] = pumpingLake;
            } else {
                res[i] = -1;
                if (rainedSet.contains(rainDay)) {
                    return new int[0];
                }
                rainedSet.add(rainDay);
                index++;
            }
        }
        return res;
    }

    /**
     * 优化后
     */
    public static int[] avoidFlood1(int[] rains) {
        int[] asn = new int[rains.length];
        HashMap<Integer, List<Integer>> rainMap = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) {
                List<Integer> orDefault = rainMap.getOrDefault(rains[i], new ArrayList<>());
                orDefault.add(i);
                rainMap.put(rains[i], orDefault);
            }
        }
        TreeSet<Integer> canUseDay = new TreeSet<>();
        for (int i = 0; i < rains.length; i++) {
            int rainLake = rains[i];
            if (rainLake != 0) {
                List<Integer> rainedDayList = rainMap.get(rainLake);
                if (rainedDayList.get(0) != i) {
                    Integer lastRainDay = rainedDayList.get(0);
                    Integer higher = canUseDay.higher(lastRainDay);
                    if (higher == null) {
                        return new int[0];
                    } else {
                        asn[higher] = rainLake;
                        canUseDay.remove(higher);
                    }
                    rainedDayList.remove(0);
                    rainMap.put(rainLake, rainedDayList);
                }
                asn[i] = -1;
            } else {
                canUseDay.add(i);
            }
        }
        for (Integer integer : canUseDay) {
            asn[integer] = 1;
        }
        return asn;
    }

    public static void main(String[] args) throws IOException {
//        ArrayList<Integer> rainsList = new ArrayList();
//
//
//        FileInputStream fin = new FileInputStream("D:\\Project\\leetCode\\src\\files\\txt01.txt");
//        InputStreamReader reader = new InputStreamReader(fin);
//        BufferedReader buffReader = new BufferedReader(reader);
//        String strTmp = "";
//        while ((strTmp = buffReader.readLine()) != null) {
//            String[] split = strTmp.split(",");
//            for (String s : split) {
//                rainsList.add(Integer.parseInt(s));
//            }
//        }
//        int[] rains = new int[rainsList.size()];
//        for (int i = 0; i < rainsList.size(); i++) {
//            rains[i] = rainsList.get(i);
//        }
        int[] rains = new int[]{1, 2, 0, 2, 3, 0, 1};
        System.out.println(Arrays.toString(avoidFlood(rains)));
        System.out.println(Arrays.toString(avoidFlood1(rains)));
    }
}
