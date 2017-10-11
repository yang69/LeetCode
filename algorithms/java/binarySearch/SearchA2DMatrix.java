package binarySearch;

/**
 * Created by Yang on 2017/10/8.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int lo = 0, hi = matrix.length - 1;
        while(lo < hi) {
            int mid = lo + (hi-lo+1)/2;
            if(matrix[mid][0] > target) {
                hi = mid - 1;
            }
            else {
                lo = mid;
            }
        }
        int row = lo;
        lo = 0;
        hi = matrix[0].length - 1;
        while(lo < hi) {
            int mid = lo + (hi-lo+1)/2;
            if(matrix[row][mid] > target) {
                hi = mid - 1;
            }
            else {
                lo = mid;
            }
        }
        return matrix[row][lo] == target;
    }
}
