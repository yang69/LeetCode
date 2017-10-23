package string;

/**
 * Created by Yang on 2017/8/27.
 ************************************************************************************************
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t. t is potentially
 * a very long (length ~= 500,000) string, and s is a short string (<=100).
 * A subsequence of a string is a new string which is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions of
 * the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 *  Input:  "s = "abc", t = "ahbgdc"
 *  Output: true
 *
 * Example 2:
 *  Input:  s = "axc", t = "ahbgdc"
 *  Output: false
 *
 * Follow up:
 *      If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to
 *      check one by one to see if T has its subsequence. In this scenario, how would you change
 *      your code?
 ************************************************************************************************
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(count)) {
                count++;
            }
            if (count == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();

        System.out.println(isSubsequence.isSubsequence("abc","ahbgdc") + " <---> true");
        System.out.println(isSubsequence.isSubsequence("axc","ahbgdc") + " <---> false");
    }
}
