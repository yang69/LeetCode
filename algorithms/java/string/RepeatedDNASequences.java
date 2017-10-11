package string;

import java.util.*;

/**
 * Created by Yang on 2017/10/9.
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sequence = s.substring(i, i + 10);
            map.put(sequence, map.getOrDefault(sequence, 0) + 1);
        }
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            if ((Integer) entry.getValue() > 1) {
                res.add((String) entry.getKey());
            }
        }
        return res;
    }
}
