package dynamicProgramming.greedy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yang on 2017/10/7.
 */
public class JumpGameII {
    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int step = 0;
        int currentLongestPosition = 0; // 在当前step步数限制下能达到的最右侧的位置
        int nextLongestPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 == currentLongestPosition) { //到达了第一个当前step步数限制下不能到达的位置
                step++; // 到达这个位置需要多走一步（题目有说末尾是一定可达的）
                currentLongestPosition = nextLongestPosition; // 多走一步的情况下，能到达的最右侧的位置
            }
            nextLongestPosition = Math.max(nextLongestPosition, i + nums[i]);
        }

        return step;
    }

    /**
     * BFS，不通过，TLE
     * @param nums
     * @return
     */
    public int jumpBFS(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int step = 1;
        while (true) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int current = q.poll();
                if (current + nums[current] >= nums.length - 1) {
                    return step;
                } else {
                    for (int j = 1; j <= nums[current]; j++) {
                        q.offer(current + j);
                    }
                }
            }
            step++;
        }
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();

        System.out.println(jumpGameII.jump(new int[]{2,3,1,1,4})
                + " <---> " + jumpGameII.jumpBFS(new int[]{2,3,1,1,4}));
        System.out.println(jumpGameII.jump(new int[]{2,3})
                + " <---> " + jumpGameII.jumpBFS(new int[]{2,3}));
        System.out.println(jumpGameII.jump(new int[]{5,4,7,1,2,3,8,2,1,5,6,2,4,8,3,1,0,5,7})
                + " <---> " + jumpGameII.jumpBFS(new int[]{5,4,7,1,2,3,8,2,1,5,6,2,4,8,3,1,0,5,7}));
    }
}
