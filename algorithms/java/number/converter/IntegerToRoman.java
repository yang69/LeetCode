package number.converter;

/**
 * Created by Yang on 2017/10/4.
 ************************************************************************************************
 * 12. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/
 * 数字转换
 *  13. Roman to Integer（罗马数字转阿拉伯数字）
 *  660. Remove 9（十进制转九进制）
 ************************************************************************************************
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 ************************************************************************************************
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < values.length; i++) {
            while(num >= values[i]) {
                sb.append(strs[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
