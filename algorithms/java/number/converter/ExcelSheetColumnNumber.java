package number.converter;

/**
 * Created by Yang on 2017/10/9.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            res = 26*res + (int)(s.charAt(i)-'A'+1);
        }
        return res;
    }
}
