import java.util.*;

/**
 * Created by Yang on 2017/9/23.
 ************************************************************************************************
 * There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional
 * garden. Your job is to fence the entire garden using the minimum length of rope as it is
 * expensive. The garden is well fenced only if all the trees are enclosed. Your task is to help
 * find the coordinates of trees which are exactly located on the fence perimeter.
 *
 * Example 1:
 *  Input:  [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
 *  Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
 *
 * Example 2:
 *  Input:  [[1,2],[2,2],[4,2]]
 *  Output: [[1,2],[2,2],[4,2]]
 *
 * Note:
 *      All trees should be enclosed together. You cannot cut the rope to enclose trees that
 *      will separate them in more than one group.
 *      All input integers will range from 0 to 100.
 *      The garden has at least one tree.
 *      All coordinates are distinct.
 *      Input points have NO order. No order required for output.
 ************************************************************************************************
 */
public class ErectTheFence {
    public List<Point> outerTrees(Point[] points) {
//        Arrays.sort(points, new Comparator<Point>() {
//            @Override
//            public int compare(Point p, Point q) {
//                return q.x - p.x == 0 ? q.y - p.y : q.x - p.x;
//            }
//        });
        Arrays.sort(points, (p, q) -> q.x - p.x == 0 ? q.y - p.y : q.x - p.x);
        Stack<Point> hull = new Stack<>();
        for (int i = 0; i < points.length; i++) {
            while (hull.size() >= 2 && isNotCounterclockwise(hull.get(hull.size()-2), hull.get(hull.size()-1), points[i])) {
                hull.pop();
            }
            hull.push(points[i]);
        }
        hull.pop();
        for (int i = points.length - 1; i >= 0; i--) {
            while (hull.size() >= 2 && isNotCounterclockwise(hull.get(hull.size()-2), hull.get(hull.size()-1), points[i])) {
                hull.pop();
            }
            hull.push(points[i]);
        }
        return new ArrayList<>(new HashSet<>(hull));
    }

    /**
     * p,q,r三个点是否是逆时针排列的
     * PS：牵扯到向量积（外积）
     * @param p
     * @param q
     * @param r
     * @return
     */
    private boolean isNotCounterclockwise(Point p, Point q, Point r) {
        return orientation(p, q, r) > 0;
    }

    private int orientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }

    private static class Point {
        int x;
        int y;
        Point() {
            x = 0;
            y = 0;
        }
        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
