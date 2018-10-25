package medium;

/**
 * 求最短子数组，满足和大于等于给定数值
 *
 * 滑动窗口
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, len = Integer.MAX_VALUE, lenNow = 0;
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            lenNow++;
            if (sum >= s){
                found = true;
                while (sum >= s){
                    sum -= nums[i - lenNow-- + 1];
                }
                len = Math.min(len, lenNow + 1);
            }
        }
        return found ? len : 0;
    }

    public static void main(String[] args) {
        int[] test = {2,3,1,2,4,3};
        new MinimumSizeSubarraySum().minSubArrayLen(7, test);
    }


}
