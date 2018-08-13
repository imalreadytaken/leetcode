package hard;

/**
 * 遍历并递归
 * 每次假设当前的气球是这段中最后一个爆的
 * 则可以递归计算两边的得分
 * 最后计算当前气球爆掉的得分
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 *
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 *
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBalloons {
    private int[][] tmp;
    public int maxCoins(int[] nums) {
        tmp = new int[nums.length][nums.length];
        return maxCoinsOfIndex(nums, 0, nums.length - 1);
    }
    private int maxCoinsOfIndex(int[] nums, int start, int end){
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
