package onlinetest.ShangTang;

import java.util.Scanner;

/**
 * 应该用递归
 */
public class TreasureDigger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt(), B = in.nextInt();
        int n = in.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int pos = in.nextInt();
            for (int j = A + 1; j <= A + B; j++) {
                int m = pos % j;
                if (m <= A && m > 0){
                    res[i] = 2;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int r:res) {
            sb.append(r - 1);
            sb.append(" ");
        }
        System.out.print(sb.toString().trim());
    }

}
