package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/4.
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> res = new LinkedList<>(); //实际是当成一个FIFO的队列来使用，LinkedList实现了Queue接口
        res.add(""); //如果缺少这一句，下一行后，“res.peek()”处，会发生java.lang.NullPointerException
        for(int i = 0; i < digits.length(); i++) {
            while(res.peek().length() == i) { //将先前的所有字符串都取出附加下一位
                int digit = Character.getNumericValue(digits.charAt(i));
                String t = res.remove();
                for(char c : mapping[digit].toCharArray()) { //在字符串的下一位附加上各种可能的字符串
                    res.add(t + c);
                }
            }
        }
        if(res.size() == 1) { //针对输入为空字符串的情况，返回应为空，这一句去掉第5行加进去的空字符串
            res.remove();
        }
        return res;
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber lcoapn = new LetterCombinationsOfAPhoneNumber();

        System.out.println(lcoapn.letterCombinations("23")
                + " <---> [ad, ae, af, bd, be, bf, cd, ce, cf].");
    }
}
