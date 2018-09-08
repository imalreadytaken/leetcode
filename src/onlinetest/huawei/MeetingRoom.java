package onlinetest.huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class MeetingRoom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        while (!"0".equals(s)){
            String used = "0000000000000";
            int[][] lens = new int[13][14];
            ArrayList<String> res = new ArrayList<>();
            while (!"0,0".equals(s)){
                String[] times = s.split(",");
                int begin = Integer.valueOf(times[0]);
                int end = Integer.valueOf(times[1]);
                lens[end - begin][begin - 8] = 1;
                s = in.nextLine();
            }
            for (int i = 12; i >= 0; i--) {
                for (int j = 0; j < 13; j++) {
                    if (lens[i][j] == 0) continue;
                    if (used.substring(j, j + i).indexOf('1') != -1) continue;
                    System.out.println((8+j) + "," + (8 + j + i));
                    char[] usedChar= used.toCharArray();
                    for (int k = j; k < j + i; k++) {
                        usedChar[k] = '1';
                    }
                    used = new String(usedChar);
                }
            }
            s = in.nextLine();
        }
    }
}
