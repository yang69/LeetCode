/**
 * Created by Yang on 2017/8/1.
 *
 * https://leetcode.com/problems/multiply-strings/
 ************************************************************************************************
 * Given two non-negative integers num1 and num2 represented as strings, return the product of
 * num1 and num2.
 *
 * Note:
 *      The length of both num1 and num2 is < 110.
 *      Both num1 and num2 contains only digits 0-9.
 *      Both num1 and num2 does not contain any leading zero.
 *      You must not use any built-in BigInteger library or convert the inputs to integer directly.
 ************************************************************************************************
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[220];
        int[] m = new int[num1.length()];
        int[] n = new int[num2.length()];
        for (int i = 0; i < m.length; i++) {
            m[m.length-1-i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < n.length; i++) {
            n[n.length-1-i] = num2.charAt(i) - '0';
        }
        // 手算乘法的过程
        for (int i = 0; i < m.length; i++) {
            int singleBit = m[i];
            for (int j = 0; j < n.length; j++) {
                int partialProduct = singleBit * n[j];
                res[i+j] += partialProduct % 10;
                dealCarry(res, i+j);
                res[i+j+1] += partialProduct / 10;
                dealCarry(res, i+j+1);
            }
        }
        StringBuilder sb = new StringBuilder(220);
        // 跳过前导的0
        int i = 219;
        while (res[i] == 0) {
            i--;
        }
        while (i >= 0) {
            sb.append(res[i]);
            i--;
        }
        return sb.toString();
    }

    private void dealCarry(int[] num, int position) {
        while (num[position] > 9) {
            num[position+1]++;
            num[position] %= 10;
            position++;
        }
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("0","0") + " <---> 0");
        System.out.println(multiplyStrings.multiply("14","14") + " <---> 196");
        System.out.println(multiplyStrings.multiply("16546514687616547","98741647651874651641874616874651674984106545600054510") + " <---> ???");
    }
}
