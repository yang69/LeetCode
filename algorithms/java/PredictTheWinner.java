/**
 * Created by yang on 17-8-26.
 */
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int n = nums.length;
        // advantage[i][j] means "the advantage the first player will get when choose from nums[i...to...j]"
        int[][] advantage = new int[n][n];
        for (int i = 0; i < n; i++) {
            advantage[i][i] = nums[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n-len; i++) {
                int j = i+len-1;
                advantage[i][j] = Math.max(nums[i] - advantage[i+1][j], nums[j] - advantage[i][j-1]);
            }
        }

        return advantage[0][n-1] >= 0;
    }

    public static void main(String[] args) {
        PredictTheWinner predictTheWinner = new PredictTheWinner();

        System.out.println(predictTheWinner.PredictTheWinner(new int[]{1, 5, 2}) + " <---> false");
        System.out.println(predictTheWinner.PredictTheWinner(new int[]{1, 5, 233, 7}) + " <---> true");
    }
}
