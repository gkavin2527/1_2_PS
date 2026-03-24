
package week1week2;

import java.util.*;

class P3_DNSCache {
    class Entry {
        String ip;
        long expiry;

        Entry(String ip, long ttl) {
            this.ip = ip;
            this.expiry = System.currentTimeMillis() + ttl;
        }
    }

    HashMap<String, Entry> map = new HashMap<>();
    int hits = 0, misses = 0;

    public String resolve(String domain) {
        Entry e = map.get(domain);
        long now = System.currentTimeMillis();
        if (e != null && e.expiry > now) {
            hits++;
            return e.ip;
        }
        misses++;
        String ip = "1.1.1.1";
        map.put(domain, new Entry(ip, 300000));
        return ip;
    }

    public static void main(String[] args) {
        P3_DNSCache obj = new P3_DNSCache();
        System.out.println(obj.resolve("google.com"));
        System.out.println(obj.resolve("google.com"));
    }
}