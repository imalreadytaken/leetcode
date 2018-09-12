package medium;

/**
 * 动态规划
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 *
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] tmp = new int[m];
        tmp[m - 1] = obstacleGrid[n - 1][m - 1] == 0 ? 1 : 0;
        for (int i = m - 2; i >= 0; i--) {
            tmp[i] = obstacleGrid[n - 1][i] == 1 ? 0 : tmp[i + 1];
        }
        for (int i = n - 2; i >= 0 ; i--) {
            for (int j = m - 1; j >= 0 ; j--) {
                tmp[j] += obstacleGrid[i][j] == 1 ? -tmp[j] : (j == m - 1 ? 0 : tmp[j + 1]);
//                if (obstacleGrid[i][j] == 1)
//                    tmp[j] = 0;
//                else
//                    tmp[j] += j >= m - 1 ? 0 : tmp[j + 1];
            }
        }
        return tmp[0];
    }

    public static void main(String[] args) {
        int[][] test = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(test));
    }

}
