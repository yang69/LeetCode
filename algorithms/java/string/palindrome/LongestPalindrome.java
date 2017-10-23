package string.palindrome;

import java.util.HashSet;

/**
 * Created by Yang on 2017/10/23.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        //题目说的是用这些字母所能构建的最长的回文
        //所以，关键是数出相同字母的对数
        int count = 0; //相同字母的对数
        HashSet<Character> chars = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (chars.contains(s.charAt(i))) {
                chars.remove(s.charAt(i));
                count++; //找到一对相同字母
            } else {
                chars.add(s.charAt(i));
            }
        }
        if (chars.isEmpty()) {
            return 2 * count;
        } else {
            return 2 * count + 1;
        }
    }
}
