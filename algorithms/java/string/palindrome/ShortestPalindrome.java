package string.palindrome;

/**
 * Created by Yang on 2017/10/18.
 */
public class ShortestPalindrome {
    public String shortestPalindromeBruteForce(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String res = "";
        for (int len = s.length(); len >= 0; len--) {
            if (isPalindrome(s, 0, len)) {
                res =  new StringBuilder(s.substring(len)).reverse().append(s).toString();
                break;
            }
        }

        return res;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end + 1) {
            if (s.charAt(start++) != s.charAt(--end)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ShortestPalindrome shortestPalindrome = new ShortestPalindrome();

        System.out.println(shortestPalindrome.shortestPalindromeBruteForce("aacecaaa") + " <---> aaacecaaa");
        System.out.println(shortestPalindrome.shortestPalindromeBruteForce("abcd") + " <---> dcbabcd");
    }
}
