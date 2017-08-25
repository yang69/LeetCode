/**
 * Created by Yang on 2017/8/25.
 ************************************************************************************************
 * Given a string, your task is to count how many palindromic substrings in this string. The
 * substrings with different start indexes or end indexes are counted as different substrings
 * even they consist of same characters.
 *
 * Example 1:
 *  Input:  "abc"
 *  Output: 3
 *  Explanation:
 *      Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 *  Input:  "aaa"
 *  Output: 6
 *  Explanation:
 *      Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 * Note:
 *      The input string length won't exceed 1000.
 ************************************************************************************************
 */
public class PalindromicSubstrings {
    /**
     * 一共有2*n-1个可能的回文中心
     * 从中心向两边扩展回文
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int[] count = new int[1];
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i, count); // 奇数长度的回文
            extendPalindrome(s, i, i+1, count); // 偶数长度的回文
        }

        return count[0];
    }

    private void extendPalindrome(String s, int from, int to, int[] count) {
        while (from >= 0 && to < s.length() && s.charAt(from) == s.charAt(to)) {
            count[0]++;
            from--;
            to++;
        }
    }

    /**
     * 从两边向中间寻找，DP
     * @param s
     * @return
     */
    public int countSubstrings1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        // isPalindrom[i][j]表示从i开始，长为j的子串，是否是回文的
        boolean[][] isPalindrom = new boolean[len][len+1];
        for (int i = 0; i < len; i++) {
            isPalindrom[i][0] = true; //长为0的子串，认为是回文的，添加此项方便递归。不计数
            isPalindrom[i][1] = true; //长为1的子串，是回文的
        }
        for (int j = 2; j <= len; j++) {
            for (int i = 0; i+j <= len; i++) {
                if (s.charAt(i) == s.charAt(i+j-1)) {
                    isPalindrom[i][j] = isPalindrom[i+1][j-2];
                } else {
                    isPalindrom[i][j] = false;
                }
            }
        }
        int res = 0;
        for (int j = 1; j <= len; j++) {
            for (int i = 0; i+j <= len; i++) {
                if (isPalindrom[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();

        System.out.println(palindromicSubstrings.countSubstrings("abc") + " <---> 3");
        System.out.println(palindromicSubstrings.countSubstrings("aaa") + " <---> 6");
    }
}
