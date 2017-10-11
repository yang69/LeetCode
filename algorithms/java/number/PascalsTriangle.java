package number;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2017/10/9.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows < 1) return res;
        for (int i = 0; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            if (i == 0) {
                current.add(1);
            } else {
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        current.add(1);
                    } else {
                        current.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                    }
                }
            }
            res.add(current);
        }
        return res;
    }
}
