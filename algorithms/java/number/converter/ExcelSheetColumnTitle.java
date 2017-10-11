package number.converter;

/**
 * Created by Yang on 2017/10/9.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            sb.append((char)('A'+(--n)%26));
            n = n/26;
        }
        return sb.reverse().toString();
    }
}
