package week1week2;

import java.util.*;

class P6_RateLimiter {
    class Bucket {
        int tokens;
        long last;

        Bucket(int max) {
            tokens = max;
            last = System.currentTimeMillis();
        }
    }

    HashMap<String, Bucket> map = new HashMap<>();
    int max = 5;

    public boolean allow(String client) {
        Bucket b = map.getOrDefault(client, new Bucket(max));
        long now = System.currentTimeMillis();
        if (now - b.last > 60000) {
            b.tokens = max;
            b.last = now;
        }
        if (b.tokens > 0) {
            b.tokens--;
            map.put(client, b);
            return true;
        }
        map.put(client, b);
        return false;
    }

    public static void main(String[] args) {
        P6_RateLimiter obj = new P6_RateLimiter();
        for (int i = 0; i < 7; i++) {
            System.out.println(obj.allow("user1"));
        }
    }
}