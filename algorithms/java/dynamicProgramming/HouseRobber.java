package dynamicProgramming;

/**
 * Created by Yang on 2017/10/6.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int[] dpRob = new int[nums.length+1];
        int[] dpNoRob = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            dpRob[i] = nums[i-1] + dpNoRob[i-1];
            dpNoRob[i] = Math.max(dpNoRob[i-1], dpRob[i-1]);
        }
        return Math.max(dpNoRob[nums.length],dpRob[nums.length]);
    }

    public int robOpt(int[] nums) {
        int include = 0; // 抢i
        int exclude = 0; // 不抢i
        for (int i = 0; i < nums.length; i++) {
            int in = include;
            int ex = exclude;
            include = ex + nums[i];
            exclude = Math.max(in, ex);
        }
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();

        System.out.println(houseRobber.rob(new int[]{4,1,8,6,7,2,5})
                + " <---> " + houseRobber.robOpt(new int[]{4,1,8,6,7,2,5}));
    }
}
