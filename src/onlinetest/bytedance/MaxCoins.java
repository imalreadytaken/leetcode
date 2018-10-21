package onlinetest.bytedance;

import java.util.Scanner;

public class MaxCoins {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(maxCoins(arr));
    }
    private static int[][] tmp;
    public static int maxCoins(int[] nums) {
        tmp = new int[nums.length][nums.length];
        return maxCoinsOfIndex(nums, 0, nums.length - 1);
    }
    private static int maxCoinsOfIndex(int[] nums, int start, int end){
        if (start > end) return 0;
        if (tmp[start][end] != 0) return tmp[start][end];
        int max = 0;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, maxCoinsOfIndex(nums, start, i - 1)
                    + maxCoinsOfIndex(nums, i + 1, end)
                    + nums[i]
                    * (start - 1 >= 0 ? nums[start - 1] : 1)
                    * (end + 1 < nums.length ? nums[end + 1] : 1));
        }
        tmp[start][end] = max;
        return max;
    }

}
