package dynamicProgramming;

/**
 * Created by Yang on 2017/10/7.
 * https://leetcode.com/articles/climbing-stairs
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int allWays = 0, oneStepBefore = 2, twoStepBefore = 1;
        for(int i = 2; i < n; i++) {
            allWays = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = allWays;
        }
        return allWays;
    }
}
