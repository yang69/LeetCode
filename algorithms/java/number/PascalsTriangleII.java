package number;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2017/10/9.
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {//第k行为k中取0~k的组合数
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) return res;
        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(0, 1);
            for (int j = 1; j < i; j++) {
                res.set(j, res.get(j) + res.get(j + 1));
            }
        }
        return res;
    }
}
