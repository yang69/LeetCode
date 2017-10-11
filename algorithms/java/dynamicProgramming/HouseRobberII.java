package dynamicProgramming;

/**
 * Created by Yang on 2017/10/6.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }

    private int rob(int[] nums, int lo, int hi) {
        int include = 0; // 抢i
        int exclude = 0; // 不抢i
        for (int i = lo; i <= hi; i++) {
            int in = include;
            int ex = exclude;
            include = ex + nums[i];
            exclude = Math.max(in, ex);
        }
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();

        System.out.println(houseRobberII.rob(new int[]{4,1,8,6,7,2,5}) + " <---> 20");
    }
}
