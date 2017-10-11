package number;

/**
 * Created by Yang on 2017/10/7.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if(n < 0) {
            return null;
        }
        int[][] result = new int[n][n];
        int count = 1;
        for(int r = 0, c = 0; r < (n+1)/2 && c < (n+1)/2; r++, c++) {
            //top →
            for(int j = c; j < n - c; j++) {
                result[r][j] = count++;
            }
            //right ↓
            for(int i = r + 1; i < n - r; i++) {
                result[i][n - 1 - c] = count++;
            }
            //bottom ←
            for(int j = n - 2 - r; j >= r; j--) {
                result[n - 1 - r][j] = count++;
            }
            //left ↑
            for(int i = n - 2 - c; i > c; i--) {
                result[i][c] = count++;
            }
        }
        return result;
    }
}
