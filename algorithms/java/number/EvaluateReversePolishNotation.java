package number;

import java.util.Stack;

/**
 * Created by Yang on 2017/10/9.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            int leftOperand;
            int rightOperand;
            switch (tokens[i]) {
                case "+":
                    rightOperand = stack.pop();
                    leftOperand = stack.pop();
                    stack.push(leftOperand + rightOperand);
                    break;
                case "-":
                    rightOperand = stack.pop();
                    leftOperand = stack.pop();
                    stack.push(leftOperand - rightOperand);
                    break;
                case "*":
                    rightOperand = stack.pop();
                    leftOperand = stack.pop();
                    stack.push(leftOperand * rightOperand);
                    break;
                case "/":
                    rightOperand = stack.pop();
                    leftOperand = stack.pop();
                    stack.push(leftOperand / rightOperand);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
