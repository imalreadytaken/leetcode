package onlinetest.pinduoduo;

import java.util.*;

public class Coupon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), total = 0;
        int[] goods = new int[n];
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer> coupon = new HashMap<>();
        for (int i = 0; i < n; i++) {
            goods[i] = sc.nextInt();
            total += goods[i];
        }
        Arrays.sort(goods);
        int[] used = new int[m];// 该优惠券是否已经用过
        int[] coupons = new int[m];// 优惠值
        ArrayList<Integer>[] canUse = new ArrayList[n];
        for (int i = 0; i < m; i++) {
            int man = sc.nextInt();
            int jian = sc.nextInt();
            coupons[i] = jian;
            for (int j = n - 1; goods[j] >= man; j--) {
                if (canUse[j] == null) canUse[j] = new ArrayList<Integer>();
                canUse[j].add(i);
            }
        }
        int discount = 0;
        for (ArrayList<Integer> a: canUse) {
            if (a == null) continue;
            if (a.size() == 1) {
                if (used[a.get(0)] == 0){ // 没有使用过
                    discount += coupons[a.get(0)];
                    used[a.get(0)] = 1;
                }
            }else {
                int max = 0, res = 0;
                for (int c: a) {
                    if (coupons[c] > max){
                        max = coupons[c];
                        res = c;
                    }
                }
                discount += max;
                used[res] = 1;
            }
        }
        System.out.println(total - discount);
    }

}
