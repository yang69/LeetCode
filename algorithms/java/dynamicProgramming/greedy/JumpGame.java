package dynamicProgramming.greedy;

/**
 * Created by Yang on 2017/10/7.
 */
public class JumpGame {
    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1; // 当前已知的可以到达末尾的最左侧位置
        for(int i = nums.length - 2; i >= 0; i--) { // 从右向左扫描
            if(i + nums[i] >= lastPos) {
                lastPos = i; //如果i经过nums[i]跳可以到达lastPos，因为lastPos可以到达末尾，i也可以到达末尾，更新lastPos为i
            }
        }
        return lastPos == 0;
    }
}
