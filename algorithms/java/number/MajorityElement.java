package number;

/**
 * Created by Yang on 2017/10/9.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        //major出现次数过半
        //最不利的情况就是Major, not Major, Major, not major,....
        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                count++;
                major = nums[i];
            } else if(nums[i] == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
