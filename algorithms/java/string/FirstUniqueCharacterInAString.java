package string;

/**
 * Created by Yang on 2017/10/23.
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] freq = new int[26]; //统计各个字母出现的次数
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        //寻找第一个频数为1的位置
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
