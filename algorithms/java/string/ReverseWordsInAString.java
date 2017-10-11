package string;

/**
 * Created by Yang on 2017/10/9.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] strs = s.split("\\s+");
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
