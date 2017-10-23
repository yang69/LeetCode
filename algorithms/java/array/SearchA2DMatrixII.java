package array;

/**
 * Created by Yang on 2017/10/19.
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 从右上角开始比较，小的值都在左侧，大的值都在下侧
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrixII searchA2DMatrixII = new SearchA2DMatrixII();

        System.out.println(searchA2DMatrixII.searchMatrix(
                new int[][]{{1,4,7,11,15},
                        {2,5,8,12,19},
                        {3,6,9,16,22},
                        {10,13,14,17,24},
                        {18,21,23,26,30}},5) + " <---> true");
    }
}
