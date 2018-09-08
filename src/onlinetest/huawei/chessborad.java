package onlinetest.huawei;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class chessborad {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = 10, i = 0;
        char[][] keys = new char[size][size];
        int[][] status = new int[size][size];
        while (in.hasNextLine() && i < 10) {//注意while处理多个case
            String a = in.nextLine();
            if (a.length() != size) {
                System.out.println(0);
                return;
            }
            System.arraycopy(a.toCharArray(), 0, keys[i++], 0, size);
        }
        Queue<Integer> que = new LinkedList<>();
        int[] offsets = {1, -1};
        int x = in.nextInt();
        int y = in.nextInt();
        que.offer(x);
        que.offer(y);
        status[x][y] = 1;
        while (!que.isEmpty()){
            x = que.poll();
            y = que.poll();
            if (x == 0 || y == 0 || x == size - 1 || y == size - 1) {
                System.out.println(1);
                return;
            }
            for (int offset: offsets) {
                if (x + offset >= 0 && x + offset < size && keys[x+offset][y] == '0' &&status[x+offset][y] == 0){
                    que.offer(x+offset);
                    que.offer(y);
                    status[x+offset][y] = 1;
                }
            }
            for (int offset: offsets) {
                if (y + offset >= 0 && y + offset < size && keys[x][y+offset] == '0' &&status[x][y+offset] == 0){
                    que.offer(x);
                    que.offer(y+offset);
                    status[x][y+offset] = 1;
                }
            }
        }
        System.out.println(0);
    }
}
