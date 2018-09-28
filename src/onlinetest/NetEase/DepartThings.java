package onlinetest.NetEase;

import java.util.Scanner;

public class DepartThings {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        if (n <= 2){
            System.out.println(n);
            return;
        }
        long least = 1, most = n / 2, k = 1;
        while (least < most){
            k = (least + most) / 2;
            long nn = n, a = 0, b = 0;
            while (nn > 0){
                a += k <= nn ? k : nn;
                nn -= k;
                b += nn > 0 ? nn / 10 : 0;
                nn -= nn / 10;
            }
            if (a > b){
                most = k;
            }else {
                least = k + 1;
            }
        }
        System.out.println((least + most)/2);
    }

}
