package week1week2;

import java.util.*;

class P9_TwoSumTransactions {
    public List<int[]> twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff)) {
                res.add(new int[]{map.get(diff), i});
            }
            map.put(arr[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        P9_TwoSumTransactions obj = new P9_TwoSumTransactions();
        int[] arr = {2, 7, 11, 15};
        List<int[]> res = obj.twoSum(arr, 9);
        for (int[] p : res) {
            System.out.println(p[0] + " " + p[1]);
        }
    }
}