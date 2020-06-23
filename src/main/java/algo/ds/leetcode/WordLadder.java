package algo.ds.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/word-ladder/
 * 
 * https://leetcode.com/discuss/interview-question/691300/google-onsite-find-most-similar-path-in-graph
 * 
 * @author m0k00i6
 *
 */
public class WordLadder {
    public static void main(String[] args) {
        System.out.println(
                new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair<String, Integer>(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> kv = Q.poll();
            String word = kv.getKey();
            Integer level = kv.getValue();

            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, L);
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }

                    // Otherwise, add it to BFS queue and mark it visited
                    if(!visited.containsKey(adjacentWord)) {
                        Q.add(new Pair<String, Integer>(adjacentWord, level + 1));
                        visited.put(adjacentWord, true); 
                    }
                }
            }

        }
        return 0;
    }
}


class Pair<T, X> {
    private T k;
    private X v;

    public Pair(T k, X v) {
        this.k = k;
        this.v = v;
    }

    public T getKey() {
        return this.k;
    }

    public X getValue() {
        return this.v;
    }
}
