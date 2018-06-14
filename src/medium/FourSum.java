package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


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


    public static void main(String[] args) {
        FourSum f = new FourSum();
        int[] nums = {-5,5,4,-3,0,0,4,-2};
        int target = 4;
        System.out.println(f.fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length < 4) return new ArrayList<>();

        Arrays.sort(nums);

        List<List<Integer>> result = someSum(nums, target,0, 4);
        return result == null ? new ArrayList<>() : result.stream().map((l)->{return l.stream().sorted().collect(Collectors.toList());}).distinct().collect(Collectors.toList());
    }

    private List<List<Integer>> someSum(int[] nums, int target, int index, int cnt){
        if (cnt < 1 || nums.length - index < cnt){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        if (cnt == 1){
            for (int i = index; i < nums.length; i++) {
                if (nums[i] == target){
                    List<Integer> res = new ArrayList<Integer>();
                    res.add(nums[i]);
                    result.add(res);
                }
            }
        }
        if(nums.length - index == cnt){
            int sum = 0;
            List<Integer> res = new ArrayList<>();
            for (int i = index; i < nums.length; i++) {
                sum += nums[i];
                res.add(nums[i]);
            }
            if (sum == target) result.add(res);
            return result;
        }
        List<List<Integer>> tmp = someSum(nums, target-nums[index], index+1, cnt - 1);
        if (tmp!=null){
            for ( List<Integer> l : tmp ) {
                l.add(nums[index]);
                result.add(l);
            }
        }
        tmp = someSum(nums, target, index+1,cnt);
        if (tmp!=null){
            for (List<Integer> l: someSum(nums, target, index+1,cnt)) {
                result.add(l);
            }
        }
        return result;
    }


}
