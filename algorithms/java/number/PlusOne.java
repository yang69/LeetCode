package number;

/**
 * Created by Yang on 2017/10/7.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        // if(digits.length == 0) {
        //     return 1;
        // }
        int carry = 1;
        for(int i = digits.length-1; i>=0; i--) {
            if(digits[i] == 9 && carry == 1) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = digits[i] + carry;
                carry = 0;
                break;
            }
        }
        if(carry == 1) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for(int i = 1; i < res.length; i++) {
                res[i]=0;
            }
            return res;
        }
        return digits;
    }
}
