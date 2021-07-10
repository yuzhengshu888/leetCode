package design;

import java.util.*;

//基于时间的键值存储
class TimeMap {
    private Map<String, TreeSet<Object[]>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeSet<Object[]> tset = map.getOrDefault(key, new TreeSet<Object[]>((x,y)->{
            return (int)x[1] - (int)y[1];
        }));
        tset.add(new Object[]{value, timestamp});
        if(!map.containsKey(key))
            map.put(key, tset);
    }

    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            Object[] obj = map.get(key).floor(new Object[]{"obj", timestamp});
            if(obj != null) return (String)obj[0];
        }
        return "";
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("a  ", "bar", 1);
        timeMap.set("x  ", "b", 3);
        String foo = timeMap.get("b", 3);
        System.out.println("----");
    }
}
