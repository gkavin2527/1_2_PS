package week1week2;

import java.util.*;

class P2_InventoryManager {
    HashMap<String, Integer> stock = new HashMap<>();
    HashMap<String, Queue<Integer>> waitlist = new HashMap<>();

    public synchronized boolean purchaseItem(String product, int userId) {
        int s = stock.getOrDefault(product, 0);
        if (s > 0) {
            stock.put(product, s - 1);
            return true;
        } else {
            waitlist.putIfAbsent(product, new LinkedList<>());
            waitlist.get(product).add(userId);
            return false;
        }
    }

    public int checkStock(String product) {
        return stock.getOrDefault(product, 0);
    }

    public static void main(String[] args) {
        P2_InventoryManager obj = new P2_InventoryManager();
        obj.stock.put("item1", 2);
        System.out.println(obj.purchaseItem("item1", 1));
        System.out.println(obj.purchaseItem("item1", 2));
        System.out.println(obj.purchaseItem("item1", 3));
    }
}