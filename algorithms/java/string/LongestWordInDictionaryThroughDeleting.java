package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/8.
 */
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String str : d) {
            if (isSubsequence(str, s)) {
                if (str.length() > res.length() || (str.length() == res.length() && str.compareTo(res) < 0)) {
                    res = str;
                }
            }
        }

        return res;
    }

    public String findLongestWordUsingSorting(String s, List<String> d) {
        Collections.sort(d, (s1, s2) -> s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2));
        for (String str : d) {
            if (isSubsequence(str, s)) {
                return str;
            }
        }

        return "";
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

    public static void main(String[] args) {
        LongestWordInDictionaryThroughDeleting lwidtd = new LongestWordInDictionaryThroughDeleting();

        System.out.println(lwidtd.findLongestWord("abpcplea", new LinkedList<>(Arrays.asList(new String[]{"ale","apple","monkey","plea"})))
                + " <---> " + lwidtd.findLongestWordUsingSorting("abpcplea", new LinkedList<>(Arrays.asList(new String[]{"ale","apple","monkey","plea"}))));
    }
}
