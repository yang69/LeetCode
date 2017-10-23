package array;

/**
 * Created by Yang on 2017/10/23.
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE; //递增数列的第一个数
        int second = Integer.MAX_VALUE; //递增数列的第二个数
        for (int x : nums) {
            if (x <= first) {
                // first 是目前的最小值
                first = x;
            } else if (x <= second) {
                // 此处，first < x，如果x <= second的话，那x当递增数列的第二个数肯定更好
                second = x;
            } else {
                // 此处，first < second < x，找到了连续3个递增的数
                return true;
            }
        }
        return false;
    }
}
