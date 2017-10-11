package string.parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2017/10/4.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        addingParenthesis(res, "", n, 0);
        return res;
    }

    private void addingParenthesis(List<String> res, String str, int leftCount, int rightCount) {
        if(leftCount == 0 && rightCount == 0) {
            res.add(str);
        }
        if(rightCount > 0) { //有右括号待添加
            addingParenthesis(res, str + ")", leftCount, rightCount - 1);
        }
        if(leftCount > 0) { //尚有左括号待添加
            addingParenthesis(res, str + "(", leftCount - 1, rightCount +1);
        }
    }
}
