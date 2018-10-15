package onlinetest.ShangTang;

import java.util.Arrays;
import java.util.Scanner;

public class PComputing {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int P = s.nextInt(), M = s.nextInt();
        int[] programs = new int[P];
        int[] machines = new int[M];
        int[][] peek = new int[P][M];
        for (int i = 0; i < P; i++)
            programs[i] = s.nextInt();
        for (int i = 0; i < M; i++)
            machines[i] = s.nextInt();
        for (int i = 0; i < P; i++) {
            for (int j = 0; j < M; j++) {
                int p = s.nextInt();
                if (programs[i] <= machines[j])
                    return;
            }
        }
    }

}
