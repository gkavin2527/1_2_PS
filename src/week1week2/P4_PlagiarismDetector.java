package week1week2;

import java.util.*;

class P4_PlagiarismDetector {
    HashMap<String, Set<String>> map = new HashMap<>();

    public List<String> getNGrams(String text, int n) {
        String[] words = text.split(" ");
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= words.length - n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) sb.append(words[i + j]).append(" ");
            res.add(sb.toString().trim());
        }
        return res;
    }

    public void addDocument(String id, String text) {
        for (String gram : getNGrams(text, 5)) {
            map.putIfAbsent(gram, new HashSet<>());
            map.get(gram).add(id);
        }
    }

    public int checkSimilarity(String text) {
        int count = 0;
        for (String gram : getNGrams(text, 5)) {
            if (map.containsKey(gram)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        P4_PlagiarismDetector obj = new P4_PlagiarismDetector();
        obj.addDocument("doc1", "this is a sample test document for plagiarism check");
        System.out.println(obj.checkSimilarity("this is a sample test document"));
    }
}