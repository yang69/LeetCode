package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang on 2017/10/24.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        Character notSatisfied = null;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() < k) {
                notSatisfied = entry.getKey();
                break;
            }
        }
        if (notSatisfied == null) {
            return s.length();
        }
        String[] subs = s.split(notSatisfied + "");
        int res = 0;
        for (String sub : subs) {
            res = Math.max(res, longestSubstring(sub, k));
        }

        return res;
    }
}
