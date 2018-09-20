package onlinetest.bytedance;

import java.util.Scanner;

public class Fifth {

    public static void main(String[] args) {
        System.out.println(tmp(2000));
        Scanner in = new Scanner(System.in);
        long begin = in.nextLong();
        long end = in.nextLong();
        System.out.println(tmp(end) - tmp(begin - 1));
    }

    private static int tmp(long tar){
        if (tar <= 10) return (int)tar;
        int tmp  = 10, pow = 1, res = 0;
        while (tmp <= tar){
            int t = 1;
            for (int i = 0; i < pow / 2 + 1; i++)
                t *= 9;
            for (int i = 0; i < (pow - 1) / 2; i++)
                t *= 10;
            res += t;
            tmp *= 10;
            pow++;
        }
        tmp /= 10;
        pow--;
        long b = (long)Math.pow(10, pow / 2);
        long a = tar / b - tmp / b;
        long aaa = tar/b/b;
        if (tar / b / b > 0 ){
            res += tar / b / 10 <= a ? 1 : 0;
        }else {
            res += tar/ b <= a ? 1 : 0;
        }
        for (int i = 0; i < pow / 2; i++) {
            a *= 9;
        }
        res += a;
        res += tar % b;
        return res;
    }

}
