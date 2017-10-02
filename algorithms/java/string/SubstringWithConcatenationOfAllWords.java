package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Yang on 2017/10/1.
 ************************************************************************************************
 * 30. Substring with Concatenation of All Words
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * https://discuss.leetcode.com/topic/68976/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
 * 滑动窗口：
 *  3. Longest Substring Without Repeating Characters
 *  76. Minimum Window Substring
 *  438. Find All Anagrams in a String
 ************************************************************************************************
 * You are given a string, s, and a list of words, words, that are all of the same length. Find
 * all starting indices of substring(s) in s that is a concatenation of each word in words
 * exactly once and without any intervening characters.
 *
 * Example:
 *  Input:  s = "barfoothefoobarman", words = ["foo", "bar"]
 *  Output: [0,9]
 *
 * Note:
 *      order does not matter
 ************************************************************************************************
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (s == null || words == null || s.length() < words.length * words[0].length()) {
            return res;
        }
        int wordLength = words[0].length();
        Map<String, Integer> dict = new HashMap<>(); // 需要匹配字典中的所有单词
        for (String word : words) {
            dict.put(word, dict.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> encountered = new HashMap<>(); // 当前的滑动窗口，左边界是left（包括），右边界是right（包括）
            int left = i; // 当前的滑动窗口的左边界（包括）
            for (int right = i; right <= s.length() - wordLength; right += wordLength) {
                String current = s.substring(right, right + wordLength); // 待检查的子字符串
                if (dict.containsKey(current)) { // 当前单词在字典中
                    encountered.put(current, encountered.getOrDefault(current, 0) + 1);
                    // 窗口内有多余的单词，将窗口的左边界向右移动
                    while (encountered.get(current) > dict.get(current)) {
                        String first = s.substring(left, left + wordLength);
                        encountered.put(first, encountered.get(first) - 1);
                        left += wordLength;
                    }
                    if (right - left + wordLength == wordLength * words.length) { // 找到一个匹配，将其实索引添加到res中，窗口的左边界向右滑动一个单词
                        res.add(left);
                        String first = s.substring(left, left + wordLength);
                        encountered.put(first, encountered.get(first) - 1);
                        left += wordLength;
                    }
                } else { //当前单词不在字典中，窗口左边界移动到当前单词右边，清空当前窗口
                    left = right + wordLength;
                    encountered.clear();
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords swcoaw = new SubstringWithConcatenationOfAllWords();

        System.out.println(swcoaw.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"})
                + " <---> [0, 9]");
        System.out.println(swcoaw.findSubstring("bbdccdbaaaabbacaccaaccdbdcdbabdbccdacbacbaadacdcaddcccabadcaabccabcccdaadadadccdcbcadcbabdabacda", new String[]{"abcc", "adca"})
                + " <---> [56]");
        System.out.println(swcoaw.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"})
                + " <---> [6, 9, 12]");
    }
}
