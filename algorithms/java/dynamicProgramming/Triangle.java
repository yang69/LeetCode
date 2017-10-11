package dynamicProgramming;

import java.util.List;

/**
 * Created by Yang on 2017/10/9.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1) {
            return 0;
        }
        int sideLength = triangle.size();
        int[][] dp = new int[sideLength][sideLength];
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < sideLength; i++) {
            List<Integer> list = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + list.get(0);
            for (int j = 1; j < list.size(); j++) {
                dp[i][j] = dp[i - 1][j - 1] < dp[i - 1][j] ? dp[i - 1][j - 1] + list.get(j) : dp[i - 1][j] + list.get(j);
            }
        }
        int res = dp[sideLength - 1][0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[sideLength - 1][i] < res) {
                res = dp[sideLength - 1][i];
            }
        }
        return res;
    }
}
