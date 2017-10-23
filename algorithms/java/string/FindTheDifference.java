package string;

/**
 * Created by Yang on 2017/10/23.
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char res = t.charAt(t.length() - 1); //t比s多一个字母
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return res;
    }
}
