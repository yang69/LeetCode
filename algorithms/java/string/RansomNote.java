package string;

/**
 * Created by Yang on 2017/10/23.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphaCounts = new int[26]; // 存储magazine中26个字母的出现次数
        for (int i = 0; i < magazine.length(); i++) {
            alphaCounts[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--alphaCounts[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
