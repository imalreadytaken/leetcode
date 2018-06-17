package hard;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.
 *
 * [2,3,1,1,4,1,1,2,1,2,3,1]
 * [0,*,*,*,*,*,*,*,*,*,*,*]
 * [0,1,1,*,*,*,*,*,*,*,*,*]
 * [0,1,1,2,2,*,*,*,*,*,*,*]
 * [0,1,1,2,2,3,3,3,3,*,*,*]
 * [0,1,1,2,2,3,3,3,3,4,*,*]
 * [0,1,1,2,2,3,3,3,3,4,5,5]
 *
 * 53.56% -> 95.26%
 */
public class JumpGameII {

    public static void main(String[] args) {
        int[] a = {2,3,1,1,4,1,1,2,1,2,3,1};
        JumpGameII j = new JumpGameII();
        System.out.println(j.jump(a));
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
//        if (nums.length <= 2) return 1;   // 删掉这行，从53.56% -> 95.26%  11ms->10ms
        int[] tmp = new int[nums.length];
        tmp[0] = 0;
        int index_pre = 0;
        int index_end = 1;
        int steps = 0;
        int max = 0;
        while (index_end < nums.length - 1) {
            for (int i = index_pre; i < index_end; i++) {
                max = Math.max(max,nums[i] + i);
            }
            steps++;
            max = Math.min(max,nums.length - 1);
            for (int i = index_end; i <= max; i++) {
                 tmp[i] = steps;
            }
            index_pre = index_end;
            index_end = max + 1;
        }
        if (index_end == nums.length - 1) tmp[nums.length-1] = steps + 1;
        return tmp[nums.length-1];
    }

}