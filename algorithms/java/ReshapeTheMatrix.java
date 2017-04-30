/**
 * Created by Yang on 2017/4/30.
 *
 * https://leetcode.com/problems/reshape-the-matrix/
 ************************************************************************************************
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into
 * a new one with different size but keep its original data.
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and
 * c representing the row number and column number of the wanted reshaped matrix, respectively.
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same
 * row-traversing order as they were.
 * If the 'reshape' operation with given parameters is possible and legal, output the new
 * reshaped matrix; Otherwise, output the original matrix.
 *
 * Example 1:
 *   Input:
 *      nums =
 *          [[1,2],
 *          [3,4]]
 *      r = 1, c = 4
 *   Output:
 *      [[1,2,3,4]]
 *   Explanation:
 *      The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix,
 *      fill it row by row by using the previous list.
 *
 * Example 2:
 *   Input:
 *      nums =
 *          [[1,2],
 *          [3,4]]
 *      r = 2, c = 4
 *   Output:
 *      [[1,2],
 *      [3,4]]
 *   Explanation:
 *      There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 *
 * Note:
 *      The height and width of the given matrix is in range [1, 100].
 *      The given r and c are all positive.
 ************************************************************************************************
 */
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0].length == 0 || r * c != nums.length * nums[0].length) {
            return nums;
        }

        int[][] res = new int[r][c];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[count/c][count%c] = nums[i][j];
                count++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ReshapeTheMatrix reshapeTheMatrix = new ReshapeTheMatrix();

        test(reshapeTheMatrix, new int[][]{{1,2},{3,4}}, 1, 4, new int[][]{{1,2,3,4}});
        test(reshapeTheMatrix, new int[][]{{1,2},{3,4}}, 2, 4, new int[][]{{1,2},{3,4}});
        test(reshapeTheMatrix, new int[][]{{1,2,3},{4,5,6}}, 3, 2, new int[][]{{1,2},{3,4},{5,6}});
    }

    private static void test(ReshapeTheMatrix reshapeTheMatrix, int[][] nums, int r, int c, int[][] expected) {
        int[][] res = reshapeTheMatrix.matrixReshape(nums, r, c);
        System.out.print("Output:   ");
        printMatrix(res);
        System.out.print("Expected: ");
        printMatrix(expected);
    }

    private static void printMatrix(int[][] array) {
        System.out.print("[");
        for (int row = 0; row < array.length; row++) {
            System.out.print(" [");
            for (int col = 0; col < array[0].length; col++) {
                System.out.print(" " + array[row][col] + " ");
            }
            System.out.print("] ");
        }
        System.out.println("]");
    }
}
