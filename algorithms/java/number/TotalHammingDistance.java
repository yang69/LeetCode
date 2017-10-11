package number;

/**
 * Created by Yang on 2017/10/9.
 */
public class TotalHammingDistance {
    // For each bit position 1-32 in a 32-bit integer, we count the number of integers in the array which have that
    // bit set. Then, if there are n integers in the array and k of them have a particular bit set and (n-k) do not,
    // then that bit contributes k*(n-k) hamming distance to the total.
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int n : nums) {
                if ((n & (1 << i)) == 0) {
                    count++;
                }
            }
            total += count * (nums.length - count);
        }

        return total;
    }

    public int totalHammingDistanceBruteForce(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res += hammingDistance(nums[i], nums[j]);
            }
        }

        return res;
    }

    private int hammingDistance(int x, int y) {
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
