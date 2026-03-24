package week1week2;

import java.util.*;

class P5_RealTimeAnalytics {
    HashMap<String, Integer> pageViews = new HashMap<>();
    HashMap<String, Set<String>> uniqueUsers = new HashMap<>();
    HashMap<String, Integer> sources = new HashMap<>();

    public void processEvent(String url, String userId, String source) {
        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);
        uniqueUsers.putIfAbsent(url, new HashSet<>());
        uniqueUsers.get(url).add(userId);
        sources.put(source, sources.getOrDefault(source, 0) + 1);
    }

    public static void main(String[] args) {
        P5_RealTimeAnalytics obj = new P5_RealTimeAnalytics();
        obj.processEvent("/home", "u1", "google");
        obj.processEvent("/home", "u2", "facebook");
        System.out.println(obj.pageViews);
    }
}
