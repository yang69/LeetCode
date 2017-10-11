package number;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2017/10/9.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int a = nums[0];
        int countA = 0;
        int b = nums[0];
        int countB = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) {
                countA++;
            } else if (nums[i] == b) {
                countB++;
            } else if (countA == 0) {
                a = nums[i];
                countA = 1;
            } else if (countB == 0) {
                b = nums[i];
                countB = 1;
            } else {
                countA--;
                countB--;
            }
        }
        countA = 0;
        countB = 0;
        for (int n : nums) {
            if (n == a) {
                countA++;
            } else if (n == b) {
                countB++;
            }
        }
        if (countA > nums.length / 3) {
            res.add(a);
        }
        if (countB > nums.length / 3) {
            res.add(b);
        }

        return res;
    }

    public static void main(String[] args) {
        MajorityElementII majorityElementII = new MajorityElementII();

        System.out.println(majorityElementII.majorityElement(new int[]{1,2}));
    }
}
