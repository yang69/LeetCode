package number;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/7.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rowLow = 0;
        int rowHigh = matrix.length - 1;
        int columnLow = 0;
        int columnHigh = matrix[0].length - 1;
        while (rowLow <= rowHigh && columnLow <= columnHigh) {
            // top -->
            for (int c = columnLow; c <= columnHigh; c++) {
                res.add(matrix[rowLow][c]);
            }
            // right
            if (rowHigh > rowLow) {
                for (int r = rowLow + 1; r <= rowHigh; r++) {
                    res.add(matrix[r][columnHigh]);
                }
            }
            // bottom <--
            if (rowHigh > rowLow) {
                for (int c = columnHigh - 1; c >= columnLow ; c--) {
                    res.add(matrix[rowHigh][c]);
                }
            }
            // left
            if (columnHigh > columnLow) {
                for (int r = rowHigh - 1; r > rowLow ; r--) {
                    res.add(matrix[r][columnLow]);
                }
            }
            rowLow++;
            rowHigh--;
            columnLow++;
            columnHigh--;
        }

        return res;
    }

    public List<Integer> spiralOrderBySimulation(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int i = 0, j = 0, direction = 0;
        while(true) {
            if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || visited[i][j]) {
                break;
            }
            result.add(matrix[i][j]);
            visited[i][j] = true;
            switch(direction) {
                case 0 :
                    if(j + 1 < matrix[0].length && !visited[i][j + 1]) {
                        j++;
                    }
                    else {
                        direction = (direction + 1) % 4;
                        i++;
                    }
                    break;
                case 1 :
                    if(i + 1 < matrix.length && !visited[i + 1][j]) {
                        i++;
                    }
                    else {
                        direction = (direction + 1) % 4;
                        j--;
                    }
                    break;
                case 2 :
                    if(j - 1 >= 0 && !visited[i][j - 1]) {
                        j--;
                    }
                    else {
                        direction = (direction + 1) % 4;
                        i--;
                    }
                    break;
                case 3 :
                    if(i - 1 >= 0 && !visited[i-1][j]) {
                        i--;
                    }
                    else {
                        direction = (direction + 1) % 4;
                        j++;
                    }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();

        System.out.println(spiralMatrix.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})
                + " <---> " + spiralMatrix.spiralOrderBySimulation(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(spiralMatrix.spiralOrder(new int[][]{{1,2,3}})
                + " <---> " + spiralMatrix.spiralOrderBySimulation(new int[][]{{1,2,3}}));
        System.out.println(spiralMatrix.spiralOrder(new int[][]{{1},{4},{7}})
                + " <---> " + spiralMatrix.spiralOrderBySimulation(new int[][]{{1},{4},{7}}));
    }
}
