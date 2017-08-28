/**
 * Created by Yang on 2017/8/28.
 ************************************************************************************************
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it
 * represented by array nums. You are asked to burst all the balloons. If the you burst
 * balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right
 * are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 *      You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst
 *      them.
 *      0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * Example 1:
 *  Input:  [3, 1, 5, 8]
 *  Output: 167
 *  Explanation:
 *          nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *         coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 ************************************************************************************************
 */
public class BurstBalloons {
    /**
     * 表格法，划分子问题
     * https://discuss.leetcode.com/topic/30746/share-some-analysis-and-explanations/2
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        // balloons保存所有气球的值，在两侧加上值为1的气球
        int[] balloons = new int[nums.length + 2];
        balloons[0] = 1;
        int n = 1;
        // 跳过值为0的气球，因为值为0的气球不会贡献Coin，在第一回合，我们就把这些值为0的气球都击毁
        for (int num : nums) {
            if (num > 0) {
                balloons[n++] = num;
            }
        }
        balloons[n++] = 1;

        int[][] memo = new int[n][n];
        return burst(memo, balloons, 0, n-1);
    }

    /**
     * 击毁left到right之间的balloons能得到的最大Coins（不包括left和right，left和right是边界）
     * @param memo
     * @param left
     * @param right
     * @return
     */
    private int burst(int[][] memo, int[] balloons, int left, int right) {
        if (left + 1 == right) { // left到right之间没有剩余的气球
            return 0;
        }
        if (memo[left][right] > 0) { // 如果已经计算过，直接返回。(left,right)之间有气球的情况下得分一定大于0（因为值为0的气球在预处理的时候就消灭掉了）
            return memo[left][right];
        }
        int ans = 0;
        // 击毁(left,i)之间的气球，再击毁(i,right)，最后击毁气球i
        // 遍历i的各种可能性，找到其中的最大值
        for (int i = left+1; i < right; i++) {
            ans = Math.max(ans, balloons[left] * balloons[i] * balloons[right]
                    + burst(memo, balloons, left, i) + burst(memo, balloons, i, right));
        }

        // 在表格中记录一下，另一处调用的地方就可以不用重复计算了
        memo[left][right] = ans;
        return ans;
    }

    public static void main(String[] args) {
        BurstBalloons burstBalloons = new BurstBalloons();

        System.out.println(burstBalloons.maxCoins(new int[]{3,1,5,8}) + " <---> 167");
        System.out.println(burstBalloons.maxCoins(new int[]{8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5,5}) + " <---> 3830");
    }
}
