package week1week2;

import java.util.*;

class P7_AutocompleteSystem {
    HashMap<String, Integer> freq = new HashMap<>();

    public void addQuery(String q) {
        freq.put(q, freq.getOrDefault(q, 0) + 1);
    }

    public static void main(String[] args) {
        P7_AutocompleteSystem obj = new P7_AutocompleteSystem();
        obj.addQuery("java");
        obj.addQuery("java");
        obj.addQuery("javascript");
        System.out.println(obj.freq);
    }
}