package hard;

import java.util.*;

/**
 * There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. Your job is to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed. Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.
 * <p>
 * Example 1:
 * Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
 * Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
 * Explanation:
 * <p>
 * Example 2:
 * Input: [[1,2],[2,2],[4,2]]
 * Output: [[1,2],[2,2],[4,2]]
 * Explanation:
 * <p>
 * Even you only have trees in a line, you need to use rope to enclose them.
 * Note:
 * <p>
 * All trees should be enclosed together. You cannot cut the rope to enclose trees that will separate them in more than one group.
 * All input integers will range from 0 to 100.
 * The garden has at least one tree.
 * All coordinates are distinct.
 * Input points have NO order. No order required for output.
 */
public class ErectTheFence {

    public int orientation(Point a, Point b, Point c) {
        int r = (b.y - a.y) * (c.x - b.x) - (b.x - a.x) * (c.y - b.y);
        return r;
    }

    public List<Point> outerTrees(Point[] points) {
        Arrays.sort(points, (Point a, Point b) -> a.x == b.x ? a.y - b.y : a.x - b.x);
        LinkedList<Point> res = new LinkedList<>();
        // 从左到右
        for (int i = 0; i < points.length; i++) {
            while (res.size() >= 2 && orientation(res.get(1), res.get(0), points[i]) > 0) {
                res.pop();
            }
            res.push(points[i]);
        }
        res.pop(); // 这里如果不pop，则需要从倒数第二个开始，则需要判断point是否为空
        // 从右到左
        for (int i = points.length - 1; i >= 0; i--) {
            while (res.size() >= 2 && orientation(res.get(1), res.get(0), points[i]) > 0) {
                res.pop();
            }
            res.push(points[i]);
        }

        return new ArrayList<>(new HashSet<>(res));
    }

    public static void main(String[] args) {
        int[][] test = {{0,0},{0,100},{100,100},{100,0},{50,50}};
        Point[] p = new Point[test.length];
        for (int i = 0; i < test.length; i++) {
            p[i] = new Point(test[i][0], test[i][1]);
        }
        System.out.println(new ErectTheFence().outerTrees(p));
    }

}

class Point {
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
