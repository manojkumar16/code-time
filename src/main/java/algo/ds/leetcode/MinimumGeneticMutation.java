package algo.ds.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-genetic-mutation/
 * 
 * Similar to https://leetcode.com/problems/word-ladder/
 * 
 * @author m0k00i6
 *
 */
public class MinimumGeneticMutation {

    public static void main(String[] args) {
        int r1 = new MinimumGeneticMutation().minMutation("AACCGGTT", "AAACGGTA",
                new String[] {"AACCGGTA", "AACCGCTA", "AAACGGTA"});

        int r2 = new MinimumGeneticMutation().minMutation("AAAAACCC", "AACCCCCC",
                new String[] {"AAAACCCC", "AAACCCCC", "AACCCCCC"});
        
        System.out.println(r1);
        System.out.println(r2);
    }

    public int minMutation(String start, String end, String[] bank) {

        int L = start.length();

        Map<String, List<String>> dict = new HashMap<>();

        for (String b : bank) {
            for (int i = 0; i < L; i++) {
                String newWord = b.substring(0, i) + '*' + b.substring(i + 1, L);
                List<String> transformations = dict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(b);
                dict.put(newWord, transformations);
            }
        }

        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();

        visited.put(start, true);
        Q.add(new Pair<String, Integer>(start, 0));

        while (!Q.isEmpty()) {
            Pair<String, Integer> kv = Q.poll();
            String word = kv.getKey();
            Integer distance = kv.getValue();

            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                for (String adj : dict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adj.equals(end)) {
                        return distance + 1;
                    }

                    if (!visited.containsKey(adj)) {
                        Q.add(new Pair<String, Integer>(adj, distance + 1));
                        visited.put(adj, true);
                    }
                }
            }
        }

        return -1;
    }
}
