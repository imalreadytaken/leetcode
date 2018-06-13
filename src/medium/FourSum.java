package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target,
 * are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */

public class FourSum {

    List<List<Integer>> result;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        result = new ArrayList<>();

        return result;
    }

    private List<List<Integer>> someSum(int[] nums, int target, int index, int cnt){
        if (nums.length - index < cnt){
            return null;
        }
        if(nums.length - index == cnt){
            int sum = 0;
            List<Integer> res = new ArrayList<>();
            for (int i = index; i < nums.length; i++) {
                sum += nums[i];
                res.add(nums[i]);
            }
            if (sum == target) ;
        }
        for ( List<Integer> l : someSum(nums, target-nums[index], index+1, cnt - 1) ) {
            l.add(nums[index]);
            result.add(l);
        }
        for (List<Integer> l: someSum(nums, target, index+1,cnt)) {
            result.add(l);
        }
        return result;
    }


}
