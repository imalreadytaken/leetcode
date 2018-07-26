package medium;

/**
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int max = 0, m = matrix.length, n = matrix[0].length, down, right;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0 ; j--) {
                if (matrix[i][j] == '1') {
                    right = matrix[i][j+1] - '0';
                    down = matrix[i+1][j] - '0';
                    if (right == down) matrix[i][j] += right - (matrix[i+right][j+right] >= '1' ? 0 : 1);
                    else matrix[i][j] += Math.min(right, down);
                    max = Math.max(max, matrix[i][j] - '0');
                }
            }
        }
        if (max == 0){
            for (int i = 0; i < m; i++) {
                if (matrix[i][n-1] == '1') return 1;
            }
            for (int i = 0; i < n; i++) {
                if (matrix[m-1][i] == '1') return 1;
            }
        }
        return max*max;
    }

}
