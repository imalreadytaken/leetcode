package hard;

import java.util.*;

/**
 * 使用字符串存储序列，便于判断
 * bfs遍历寻找可能出现的情况，查找是否有解
 * 存储已经出现过的序列
 * 如果所有序列都已经出现过依然无解，则返回-1
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 *
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 *
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 *
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
 *
 * Examples:
 *
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 * Input: board = [[3,2,4],[1,5,0]]
 * Output: 14
 * Note:
 *
 * board will be a 2 x 3 array as described above.
 * board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 */
public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        int width = board[0].length;
        Queue<String> que = new LinkedList<>();
        Set<String> found = new HashSet<>();
        que.add(Arrays.deepToString(board).replaceAll("\\[|\\]|\\s|,",""));
        found.add(que.peek());
        // 上下左右四种操作
        int[] operate = {1,-1,width,-width};
        int res = 0;
        while (!que.isEmpty()){
            // 遍历当前队列中的序列
            for (int i = que.size(); i > 0; i--) {
                String s = que.poll();
                if (target.equals(s)) return res;
                for (int j = 0; j < 4; j++) {
                    int zero = s.indexOf('0'), zeroNext = zero + operate[j];
                    // 交换的位置在合理范围
                    if (zeroNext >= s.length() || zeroNext < 0 || (zero % width == 0 && j == 1) || (zero % width == width - 1 && j == 0))
                        continue;
                    char[] cs = s.toCharArray();
                    cs[zero] = cs[zeroNext];
                    cs[zeroNext] = '0';
                    String gen = new String(cs);
                    // 尚未出现过该序列
                    if (found.add(gen)) que.offer(gen);
                }
            }
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,0,5}};
        System.out.println(new SlidingPuzzle().slidingPuzzle(a));
    }
}
