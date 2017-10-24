package string;

import java.util.*;

/**
 * Created by Yang on 2017/10/24.
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        // https://discuss.leetcode.com/topic/77773/short-easy-java-with-explanation
        String[] keys = new String[]{"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        Map<Character, Integer> rowIndexMap = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            for (int j = 0; j < keys[i].length(); j++) {
                rowIndexMap.put(keys[i].charAt(j), i);
            }
        }
        List<String> res = new LinkedList<>();
        for (String word : words) {
            if (word == null || word.equals("")) {
                continue;
            }
            int rowIndex = rowIndexMap.get(Character.toUpperCase(word.charAt(0)));
            for (int i = 0; i < word.length(); i++) {
                if (rowIndexMap.get(Character.toUpperCase(word.charAt(i))) != rowIndex) {
                    rowIndex = -1;
                    break;
                }
            }
            if (rowIndex != -1) {
                res.add(word);
            }
        }

        return res.toArray(new String[0]);
    }
}
