package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/9/30.
 ************************************************************************************************
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * https://discuss.leetcode.com/topic/68976/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
 * 变位词（异序词）：242. Valid Anagram
 * 滑动窗口：
 *  3. Longest Substring Without Repeating Characters
 *  30. Substring with Concatenation of All Words
 *  76. Minimum Window Substring
 ************************************************************************************************
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will
 * not be larger than 20,100.
 * The order of output does not matter.
 *
 * Example 1:
 *  Input:  s = "cbaebabacd", t = "abc"
 *  Output: [0, 6]
 *  Explanation:
 *      The substring with start index = 0 is "cba", which is an anagram of "abc".
 *      The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *  Input:  s = "abab", t = "ab"
 *  Output: [0, 1, 2]
 *  Explanation:
 *      The substring with start index = 0 is "ab", which is an anagram of "ab".
 *      The substring with start index = 1 is "ba", which is an anagram of "ab".
 *      The substring with start index = 2 is "ab", which is an anagram of "ab".
 ************************************************************************************************
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s == null || p.length() > s.length()) {
            return res;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = p.length();

        int left = 0;
        int right = 0;
        char ch;
        while (right < s.length()) {
            // 滑动窗口的右边界向右扩大一格
            ch = s.charAt(right);
            right++;
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) {
                    count--;
                }
            }
            // 当滑动窗口内包含p中的所有字符时，找到一个异位词
            if (count == 0) {
                res.add(left);
            }
            // 滑动窗口的左边界向右收缩一格
            if (right - left == p.length()) {
                ch = s.charAt(left);
                left++;
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                    if (map.get(ch) > 0) {
                        count++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString faaias = new FindAllAnagramsInAString();

        System.out.println(faaias.findAnagrams("cbaebabacd", "abc"));
        System.out.println(faaias.findAnagrams("abab", "ab"));
    }
}
