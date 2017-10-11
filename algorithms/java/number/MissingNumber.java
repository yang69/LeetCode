package number;

/**
 * Created by Yang on 2017/10/5.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i <= nums.length; i++) {
            res ^= i;
        }
        for (int n : nums) {
            res ^= n;
        }

        return res;
    }

    public int missingNumber1(int[] nums) {
        int count = 0;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            count++;
            sum += n;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        if (min != 0) {
            return 0;
        }
        if (max != count) {
            return count;
        }
        return (int)(((long)min + max) * (count + 1) / 2 - sum);
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();

        System.out.println(missingNumber.missingNumber(new int[]{0,1,3})
                + " <---> " + missingNumber.missingNumber1(new int[]{0,1,3}));
    }
}
