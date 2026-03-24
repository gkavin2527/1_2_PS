package week1week2;

import java.util.*;

class P1_UsernameChecker {
    HashMap<String, Integer> users = new HashMap<>();
    HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public void register(String username, int userId) {
        users.put(username, userId);
    }

    public List<String> suggestAlternatives(String username) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= 3; i++) res.add(username + i);
        res.add(username.replace("_", "."));
        return res;
    }

    public String getMostAttempted() {
        return Collections.max(attempts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        P1_UsernameChecker obj = new P1_UsernameChecker();
        System.out.println(obj.checkAvailability("john_doe"));
        obj.register("john_doe", 1);
        System.out.println(obj.checkAvailability("john_doe"));
        System.out.println(obj.suggestAlternatives("john_doe"));
    }
}