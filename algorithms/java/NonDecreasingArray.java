/**
 * Created by yang on 17-8-27.
 */
public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                if (count > 0) {
                    return false;
                }
                if (i == 1 || (i > 1 && nums[i] >= nums[i-2])) {
                    count++;
                } else if (i == nums.length - 1 || (i < nums.length - 1 && nums[i+1] >= nums[i-1])) {
                    count++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
//    [4,2,3] true
//            [4,2,1] false
//            [2,3,3,2,4] true
}
