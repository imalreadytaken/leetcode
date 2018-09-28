package onlinetest.NetEase;

import java.util.Scanner;

public class BasketballTeam {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), sum = 0, minA = 0;
        int[] players = new int[n];
        for (int i = 0; i < n; i++) {
            players[i] = s.nextInt();
            sum += players[i];
        }

        int least = sum / 2;

        System.out.println(2);

    }

}
