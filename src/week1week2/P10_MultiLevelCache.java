package week1week2;

import java.util.*;

class P10_MultiLevelCache {
    LinkedHashMap<String, String> L1;
    HashMap<String, String> L2;

    P10_MultiLevelCache(int cap) {
        L1 = new LinkedHashMap<>(cap, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, String> e) {
                return size() > cap;
            }
        };
        L2 = new HashMap<>();
    }

    public String get(String key) {
        if (L1.containsKey(key)) return L1.get(key);
        if (L2.containsKey(key)) {
            String val = L2.get(key);
            L1.put(key, val);
            return val;
        }
        String val = "DB";
        L2.put(key, val);
        return val;
    }

    public static void main(String[] args) {
        P10_MultiLevelCache obj = new P10_MultiLevelCache(2);
        System.out.println(obj.get("A"));
        System.out.println(obj.get("A"));
    }
}