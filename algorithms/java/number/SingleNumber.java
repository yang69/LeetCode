package number;

/**
 * Created by Yang on 2017/10/5.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {//a异或a=0
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res ^= nums[i];//全部数异或一遍，只有出现奇数次的那个数对最终结果有影响
        }
        return res;
    }
}
