package onlinetest.pinduoduo;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Gold {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), a = sc.nextInt(), r = sc.nextInt();

        Queue<Integer> toAdd = new LinkedList<>();
        toAdd.offer(0);
        float total = 0;
        float used = 0;
        while (!toAdd.isEmpty()) {
            int tmp = toAdd.poll();
            if (tmp != 0) {
                total++;
                used += tmp <= m ? 1 : 0;
            }
            if (tmp < a) {
                for (int i = 0; i < r; i++) {
                    toAdd.offer(tmp + i + 1);
                }
            }
        }
        float res = used / total;
        DecimalFormat fnum = new DecimalFormat("##0.00000 ");
        String dd = fnum.format(res);
        System.out.println(dd);
    }

}
