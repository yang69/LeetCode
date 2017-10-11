package string;

/**
 * Created by Yang on 2017/10/11.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int idxs = (int) s.charAt(i);
            int idxt = (int) t.charAt(i);
            if (m1[idxs] != m2[idxt]) return false;
            m1[idxs] = i + 1;
            m2[idxt] = i + 1;
        }
        return true;
    }
}
