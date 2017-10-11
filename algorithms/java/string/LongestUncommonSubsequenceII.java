package string;

import java.util.Arrays;

/**
 * Created by Yang on 2017/10/8.
 */
public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());
        for (int i = 0; i < strs.length; i++) {
            int mismatchCount = strs.length - 1;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && !isSubsequence(strs[i], strs[j])) {
                    mismatchCount--;
                }
            }
            if (mismatchCount == 0) {
                return strs[i].length();
            }
        }

        return -1;
    }

    /**
     * 判断s是否是t的子序列
     * @param s
     * @param t
     * @return
     */
    private boolean isSubsequence(String s, String t) {
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
}
