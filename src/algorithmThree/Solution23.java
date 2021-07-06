package algorithmThree;

import common.MyUtil;

import java.util.*;

/**
 * @description: 1418. 点菜展示表
 * @Author: yuzhengshu
 * @Date: 2021年7月6日 09:47
 */
public class Solution23 {
    public static List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> foodMap = new TreeSet<>();
        TreeMap<String, HashMap<String, String>> map = new TreeMap<>((o1, o2) -> {
            int a = Integer.parseInt(o1);
            int b = Integer.parseInt(o2);
            return a - b;
        });
        for (List<String> order : orders) {
            String customerName = order.get(0);
            String tableNumber = order.get(1);
            String foodItem = order.get(2);
            foodMap.add(foodItem);
            HashMap<String, String> tempMap = map.get(tableNumber);
            if (tempMap != null) {
                String s = tempMap.get(foodItem);
                if (s != null) {
                    tempMap.put(foodItem, String.valueOf(Integer.parseInt(s) + 1));
                } else {
                    tempMap.put(foodItem, "1");
                }
            } else {
                tempMap = new HashMap<>();
                tempMap.put(foodItem, "1");
            }
            map.put(tableNumber, tempMap);
        }
        List<List<String>> asn = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodMap);
        asn.add(header);

        for (Map.Entry<String, HashMap<String, String>> entry : map.entrySet()) {
            List<String> addList = new ArrayList<>();
            String tableNumber = entry.getKey();
            addList.add(tableNumber);
            HashMap<String, String> foodItemMap = entry.getValue();
            for (String s : foodMap) {
                String s1 = foodItemMap.get(s);
                if (s1 == null) {
                    addList.add("0");
                } else {
                    addList.add(s1);
                }
            }
            asn.add(addList);
        }
        return asn;
    }

    public static void main(String[] args) {
        String s = MyUtil.castNums("[[\"David\",\"3\",\"Ceviche\"],[\"Corina\",\"10\",\"Beef Burrito\"],[\"David\",\"3\",\"Fried Chicken\"],[\"Carla\",\"5\",\"Water\"],[\"Carla\",\"5\",\"Ceviche\"],[\"Rous\",\"3\",\"Ceviche\"]]");
        System.out.println(s);
        String[][] strings = {{"David", "3", "Ceviche"}, {"Corina", "10", "Beef Burrito"}, {"David", "3", "Fried Chicken"}, {"Carla", "5", "Water"}, {"Carla", "5", "Ceviche"}, {"Rous", "3", "Ceviche"}};
        List<List<String>> list = new ArrayList<>();
        for (String[] string : strings) {
            List<String> addList = new ArrayList<>(Arrays.asList(string));
            list.add(addList);
        }

        System.out.println(displayTable(list));
    }
}
