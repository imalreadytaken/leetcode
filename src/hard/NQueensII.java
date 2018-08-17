package hard;

/**
 * 递归，
 * 如已经安置好全部棋子，返回1
 * 遍历当前行上位置，
 * 并根据已有的标志位判断是否可以放在该位置
 * 如可以，调整标志位继续递归
 * 如不可以，返回0
 *
 * 这里使用3个long型值储存列、两个对角线的标志位
 * 如果n超过long的长度就不能用了，需要换成布尔数组
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 */
public class NQueensII {
    public int totalNQueens(int n) {
        return c(n, 0, 0, 0, 0);
    }

    private int c(int n, long v, long leftTop, long rightTop, int placed){
        if (placed == n) return 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if ( ( v>>i & 1) == 0 && ( leftTop>>(n+i-1-placed) & 1) == 0 && ( rightTop >> (placed + i) & 1) == 0){
                res += c(n,1<<i | v, 1<<(n+i-1-placed) | leftTop, 1<<(placed + i) | rightTop, placed + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new NQueensII().totalNQueens(4);
    }
//    private int c(int n, boolean[] v, boolean leftTop[], boolean[] rightTop, int placed){
//        if (placed == n) return 1;
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//        }
//        return 0;
//    }

}
