package hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@" is the starting point, ("a", "b", ...) are keys, and ("A", "B", ...) are locks.
 *
 * We start at the starting point, and one move consists of walking one space in one of the 4 cardinal directions.  We cannot walk outside the grid, or walk into a wall.  If we walk over a key, we pick it up.  We can't walk over a lock unless we have the corresponding key.
 *
 * For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter of the first K letters of the English alphabet in the grid.  This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.
 *
 * Return the lowest number of moves to acquire all keys.  If it's impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: ["@.a.#","###.#","b.A.B"]
 * Output: 8
 * Example 2:
 *
 * Input: ["@..aA","..B#.","....b"]
 * Output: 6
 *
 * Note:
 *
 * 1 <= grid.length <= 30
 * 1 <= grid[0].length <= 30
 * grid[i][j] contains only '.', '#', '@', 'a'-'f' and 'A'-'F'
 * The number of keys is in [1, 6].  Each key has a different letter and opens exactly one lock.
 *
 * 广度优先遍历。
 */
public class ShortestPathToGetAllKeys {

    public static void main(String[] args) {
        String[] grid = {".#.b.","A.#aB","#d...","@.cC.","D...#"};
        System.out.println(new ShortestPathToGetAllKeys().shortestPathAllKeys(grid));
    }

    public int shortestPathAllKeys(String[] grid) {
        int goal = 0, row = grid.length, col = grid[0].length();
        int[][] move = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Integer> que = new LinkedList<>();
        Set<String> arrived = new HashSet<>();

        // 找到所有key，以及出发点
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    que.offer(i);
                    que.offer(j);
                    que.offer(0);
                    arrived.add(buildStr(i, j, 0));
                }else if (Character.isLowerCase(c)){
                    goal |= (1 << (c - 'a') );
                }
            }
        }

        que.offer(-1);  // 一次dfs分割符
        int res = 0;
        // 开始dfs
        while (que.size() > 1){

            while (que.peek() != -1){
                int x = que.poll(), y = que.poll(), keys = que.poll();
                for (int[] oneMove : move) {
                    int xNext = x + oneMove[0], yNext = y + oneMove[1], keyNext = keys;
                    if (xNext >= 0 && xNext < row && yNext >= 0 && yNext < col){
                        char c = grid[xNext].charAt(yNext);
                        boolean add = false;
                        if (Character.isLowerCase(c)){
                            keyNext |= (1 << (c - 'a') );
                            // 相等，则已找到所有key
                            if (keyNext == goal)
                                return res + 1;
                            // 否则继续
                            add = true;
                        }else if (Character.isUpperCase(c)){
                            // 是否已有该锁的钥匙
                            if ( (keyNext & ( 1 << (c - 'A') )) > 0){
                                add = true;
                            }
                        }else if (c == '.' || c == '@'){
                            add = true;
                        }

                        if ( add && !arrived.contains(buildStr(xNext, yNext, keyNext))){
                            que.offer(xNext);
                            que.offer(yNext);
                            que.offer(keyNext);
                            arrived.add(buildStr(xNext, yNext, keyNext));
                        }

                    }
                }
            }

            res++;
            que.poll();
            que.offer(-1);  // 一次dfs分割符
        }
        return -1;
    }

    private String buildStr(int row, int col, int keys){
        return row + "-" + col + "-" + keys;
    }

}
