package string;

/**
 * Created by Yang on 2017/10/23.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += Character.getNumericValue(num1.charAt(i));
                i--;
            }
            if (j >= 0) {
                carry += Character.getNumericValue(num2.charAt(j));
                j--;
            }
            sb.append(carry % 10);
            carry = carry / 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
