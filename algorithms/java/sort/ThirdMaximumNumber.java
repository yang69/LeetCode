package sort;

/**
 * Created by Yang on 2017/10/19.
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Integer first = null;
        Integer second = null;
        Integer third = null;
        for (Integer n : nums) {
            if (n.equals(first) || n.equals(second) || n.equals(third)) {
                continue; //跳过重复的数字
            }
            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            } else if (second == null || n > second) {
                third = second;
                second = n;
            } else if (third == null || n > third) {
                third = n;
            }
        }
        return third == null ? first : third;
    }
}
