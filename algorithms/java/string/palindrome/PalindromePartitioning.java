package string.palindrome;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/9.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        backtrackingPartition(s, 0, new LinkedList<>(), res);
        return res;
    }

    private void backtrackingPartition(String s, int start, List<String> parts, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(parts));
            // return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                parts.add(s.substring(start, i));
                backtrackingPartition(s, i, parts, res);
                parts.remove(parts.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end + 1) {
            if (s.charAt(start++) != s.charAt(--end)) {
                return false;
            }
        }
        return true;
    }
}
