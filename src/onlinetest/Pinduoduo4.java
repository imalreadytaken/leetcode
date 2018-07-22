package onlinetest;

import java.util.Scanner;

/**
 * 给定一个电话号码和一个数字k
 * 将电话号码变成有连续k个数字的靓号
 * 变换数字的花费为 abs(a-b)
 * 求最小的花费
 */
public class Pinduoduo4 {

    private int leastCost(int k, String number){
        int sum = 0, cost = 0, avg, finalCost = Integer.MAX_VALUE;
        char[] numbers = number.toCharArray();
        for (int i = 0; i < k; i++) sum += numbers[i] - '0';
        avg = Math.round((float)(sum/k));
        for (int i = 0; i < k; i++) cost += Math.abs(numbers[i] - '0' - avg);
        finalCost = Math.min(finalCost, cost);
        for (int i = k; i < number.length(); i++) {
            sum += numbers[i] - numbers[i - k];
            avg = Math.round((float)(sum/k));
            cost = 0;
            for (int j = 0; j < k; j++) {
                cost += Math.abs(numbers[i - j] - '0' - avg);
            }
            finalCost = Math.min(finalCost, cost);
        }
        return finalCost;
    }

    public void solution(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), k = s.nextInt();
        s.nextLine();
        String number = s.nextLine();
        System.out.println(leastCost(k,number));
    }

    public static void main(String[] args) {
        new Pinduoduo4().solution();
    }

}
