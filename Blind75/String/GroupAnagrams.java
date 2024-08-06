package Blind75.String;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * Input: strs = ["eat","tea","tan","ate","nat","bat"] <br>
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]] <br>
 * <p>
 * <b>Example 2:</b>
 * <p>
 * Input: strs = [""] <br>
 * Output: [[""]] <br>
 * <p>
 * <b>Example 3:</b>
 * <p>
 * Input: strs = ["a"] <br>
 * Output: [["a"]]
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if (!anagramsMap.containsKey(sortedStr)) {
                anagramsMap.put(sortedStr, new ArrayList<>());
            }

            anagramsMap.get(sortedStr).add(word);
        }

        return new ArrayList<>(anagramsMap.values());
    }

    public static void main(String[] args) {
        String[] words = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> anagrams = groupAnagrams(words);
        System.out.println(anagrams);
    }
}
