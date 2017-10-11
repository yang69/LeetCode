package string;

/**
 * Created by Yang on 2017/10/7.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") -1;
    }
}
