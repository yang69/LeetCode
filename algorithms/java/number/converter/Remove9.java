package number.converter;

/**
 * Created by Yang on 2017/8/19.
 ************************************************************************************************
 * 660. Remove 9
 * https://leetcode.com/problems/remove-9/
 * 数字转换
 *  12. Integer to Roman（阿拉伯数字转罗马数字）
 *  13. Roman to Integer（罗马数字转阿拉伯数字）
 ************************************************************************************************
 * Start from integer 1, remove any integer that contains 9 such as 9, 19, 29...
 * So now, you will have a new integer sequence: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...
 * Given a positive integer n, you need to return the n-th integer after removing.
 * Note that 1 will be the first integer.
 *
 * Example:
 *  Input: 9
 *  Output: 10
 *
 * Note:
 *      n will not exceed 9 x 10^8.
 ************************************************************************************************
 */
public class Remove9 {
    /**
     * 从小到大的依次排列的不出现9的数列，那就是9进制数啊！！
     * @param n
     * @return
     */
    public int newInteger(int n) {
        return Integer.parseInt(Integer.toString(n, 9));
    }

    /**
     * 自己实现会比库函数更快
     * 十进制转k进制的通用方法是：除以k逆序取余
     * @param n
     * @return
     */
    public int newInteger2(int n) {
        int ans = 0;
        int base = 1;
        while(n != 0) {
            ans += n % 9 * base;
            n /= 9;
            base *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Remove9 remove9 = new Remove9();
        System.out.println(remove9.newInteger(9) + " <---> " + remove9.newInteger2(9));
        System.out.println(remove9.newInteger(14616748) + " <---> " + remove9.newInteger2(14616748));
    }
}
