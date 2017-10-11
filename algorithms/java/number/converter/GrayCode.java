package number.converter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/8.
 */
public class GrayCode {
    /**
     * https://en.wikipedia.org/wiki/Gray_code
     * 二进制转格雷码：
     * grayCode = binary ^ (binary >> 1);
     * 格雷码转二进制：
     * grayCode = grayCode ^ (grayCode >> 16);
     * grayCode = grayCode ^ (grayCode >> 8);
     * grayCode = grayCode ^ (grayCode >> 4);
     * grayCode = grayCode ^ (grayCode >> 2);
     * grayCode = grayCode ^ (grayCode >> 1);
     * binary = grayCode;
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList<>();
        int size = 1 << n;
        for(int i = 0; i < size; i++) {
            res.add( (i>>1)^i );
        }
        return res;
    }
}
