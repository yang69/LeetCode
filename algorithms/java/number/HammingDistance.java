package number;

/**
 * Created by Yang on 2017/10/9.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        return hammingWeight(xor);
    }

    private int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1); //此操作将使最低有效位的1置零
            res++;
        }
        return res;
    }
}
