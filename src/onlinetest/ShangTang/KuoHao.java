package onlinetest.ShangTang;

import java.util.Scanner;

public class KuoHao {

    private static int res = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int left = s.nextInt(), right = s.nextInt();
        res = 0;
        get(left, right, 0, 0);
        System.out.println(res);
    }

    private static void get(int left, int right, int l, int r){
        if (right == 0)
            res++;
        else {
            if (left > 0)
                get(left - 1, right, l + 1, r);

            if (right > 0 && l > r)
                get(left, right - 1, l, r + 1);
        }

    }

}
