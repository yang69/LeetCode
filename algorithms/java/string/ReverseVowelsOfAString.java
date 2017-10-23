package string;

/**
 * Created by Yang on 2017/10/23.
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        String vowels = "aeiouAEIOU";
        char[] c = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end) {
                if (vowels.contains(c[start] + "")) {
                    break;
                }
                start++;
            }
            while (start < end) {
                if (vowels.contains(c[end] + "")) {
                    break;
                }
                end--;
            }
            // 交换c[start]和c[end]
            char temp;
            temp = c[start];
            c[start] = c[end];
            c[end] = temp;

            start++;
            end--;
        }
        return new String(c);
    }
}
