package string;

import java.util.HashMap;

/**
 * Created by Yang on 2017/10/1.
 ************************************************************************************************
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 * https://discuss.leetcode.com/topic/68976/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
 * 滑动窗口：438. Find All Anagrams in a String
 ************************************************************************************************
 * Given a string S and a string T, find the minimum window in S which will contain all the
 * characters in T in complexity O(n).
 *
 * Example 1:
 *  Input:  s = "ADOBECODEBANC", t = "ABC"
 *  Output: "BANC"
 *
 * Note:
 *      If there is no such window in S that covers all characters in T, return the empty string "".
 *      If there are multiple such windows, you are guaranteed that there will always be only one
 *      unique minimum window in S.
 ************************************************************************************************
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = t.length();
        int begin = 0; // 滑动窗口的左边界（包括）
        int end = 0; // 滑动窗口的右边界（不包括）
        int head = 0; // minWindow对应的起始位置
        int minLength = Integer.MAX_VALUE;
        while (end < s.length()) {
            // 窗口向右滑动，直到包含t中所有字符
            while (count > 0 && end < s.length()) {
                char ch = s.charAt(end++);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) >= 0) {
                        count--;
                    }
                }
            }
            // 窗口的左边界向右收缩
            while (count == 0) {
                if (end - begin < minLength) {
                    minLength = end - begin;
                    head = begin;
                }
                char ch = s.charAt(begin++);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                    if (map.get(ch) > 0) {
                        count++;
                    }
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(head, head + minLength);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();

        System.out.println(mws.minWindow("ADOBECODEBANC", "ABC") + " <---> BANC");
        System.out.println(mws.minWindow("a", "b") + " <---> ");
    }
}
