package number;

/**
 * Created by Yang on 2017/10/5.
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int mark = 0;
        for (int i = 0; i < nums.length; i++) {
            mark ^= nums[i];
        }
        int lsb = 1;
        while ((mark & lsb) == 0) {
            lsb <<= 1;
        }
        int[] res = new int[]{0,0};
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & lsb) == 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SingleNumberIII singleNumberIII = new SingleNumberIII();

        for (int n : singleNumberIII.singleNumber(new int[]{1, 2, 1, 3, 2, 5})) {
            System.out.print(n + " ");
        }
        System.out.println(" <---> 3 5");
    }
}
