import java.util.Arrays;

/**
 * Created by Yang on 2017/6/1.
 ************************************************************************************************
 * Given the coordinates of four points in 2D space, return whether the four points could
 * construct a square.
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 *
 * Example:
 *   Input:
 *      p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 *   Output:
 *      True
 *
 * Note:
 *      All the input integers are in the range [-10000, 10000].
 *      A valid square has four equal sides with positive length and four equal angles
 *      (90-degree angles).
 *      Input points have no order.

 ************************************************************************************************
 */
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = new int[][]{p1,p2,p3,p4};
        Arrays.sort(p, (l1,l2) -> l1[0] == l2[0] ? l1[1] - l2[1] : l1[0] - l2[0]);

        //4个点不重合、4条边相等、对角线相等
        return dist(p[0], p[1]) != 0
                && dist(p[0], p[1]) == dist(p[1], p[3]) && dist(p[1], p[3]) == dist(p[3], p[2]) && dist(p[3], p[2]) == dist(p[2], p[0])
                && dist(p[0], p[3]) == dist(p[1], p[2]);
    }

    private int dist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        ValidSquare validSquare = new ValidSquare();

        int[] p1 = new int[]{0,0};
        int[] p2 = new int[]{1,1};
        int[] p3 = new int[]{0,1};
        int[] p4 = new int[]{1,0};
        System.out.println(validSquare.validSquare(p1, p2, p3, p4) + " <--> true");

        p1 = new int[]{0,0};
        p2 = new int[]{5,0};
        p3 = new int[]{5,4};
        p4 = new int[]{0,4};
        System.out.println(validSquare.validSquare(p1, p2, p3, p4) + " <--> false");
    }
}
