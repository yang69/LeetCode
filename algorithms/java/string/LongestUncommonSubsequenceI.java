package string;

/**
 * Created by Yang on 2017/10/8.
 */
public class LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        // Case 1. 两个字符串相等，必定没有不同的子序列
        if (a.equals(b)) {
            return -1;
        }
        // Case 2. 两个字符串长度相等，但是他们不相同，那这两个字符串本身就是对方的最长不同子序列
        // 运行至此处，a和b一定不等
        if (a.length() == b.length()) {
            return a.length();
        }
        // Case 3. 两个字符串长度不等，长的那个字符串一定不是短的字符串的子序列
        return Math.max(a.length(), b.length());
    }
}
