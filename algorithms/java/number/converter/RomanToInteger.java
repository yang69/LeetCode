package number.converter;

/**
 * Created by Yang on 2017/10/4.
 ************************************************************************************************
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 * 数字转换
 *  12. Integer to Roman（阿拉伯数字转罗马数字）
 *  660. Remove 9（十进制转九进制）
 ************************************************************************************************
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 ************************************************************************************************
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int[] nums = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'M' :
                    nums[i] = 1000;
                    break;
                case 'D' :
                    nums[i] = 500;
                    break;
                case 'C' :
                    nums[i] = 100;
                    break;
                case 'L' :
                    nums[i] = 50;
                    break;
                case 'X' :
                    nums[i] = 10;
                    break;
                case 'V' :
                    nums[i] = 5;
                    break;
                case 'I' :
                    nums[i] = 1;
                    break;
            }
        }

        int sum = 0;
        for(int i = 0; i < s.length()-1; i++) {
            if(nums[i] < nums[i+1]) {
                sum -= nums[i];
            }
            else {
                sum += nums[i];
            }
        }
        return sum + nums[s.length()-1];
    }
}
