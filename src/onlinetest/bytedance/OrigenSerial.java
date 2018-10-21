package onlinetest.bytedance;

import java.util.Scanner;

public class OrigenSerial {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = s.nextInt(); 
        }
        int r = 1;
        while (n-- > 0){
            r *= 2;
            r %= 1000000;
        }
        System.out.println(r);
    }

}
