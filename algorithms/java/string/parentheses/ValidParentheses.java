package string.parentheses;

import java.util.Stack;

/**
 * Created by Yang on 2017/10/4.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        // 遍历字符串
        for(int i = 0; i < s.length(); i++) {
            //遇到左括号，放入堆栈中
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            //遇到右括号，在堆栈顶中寻找与之匹配的左括号
            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            }
            else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[') {
                stack.pop();
            }
            else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{') {
                stack.pop();
            }
            //不匹配的括号
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
