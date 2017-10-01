/**
 * Created by Yang on 2017/9/19.
 ************************************************************************************************
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make
 * it a palindrome.
 *
 * Example 1:
 *  Input:  "aba"
 *  Output: true
 *
 * Example 2:
 *  Input:  "abca"
 *  Output: true
 *  Explanation:
 *      You could delete the character 'c'.
 *
 * Note:
 *      The string will only contain lowercase characters a-z. The maximum length of the string
 *      is 50000.
 ************************************************************************************************
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() < 3) {
            return true;
        }
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) {
                return isPalindrome(s, lo, hi-1) || isPalindrome(s, lo+1, hi);
            }
        }

        return true;
    }

    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) {
                return false;
            }
        }

        return true;
    }
}
