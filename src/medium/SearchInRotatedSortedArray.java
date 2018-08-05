package medium;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid;
        while (start < end){
            mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[end] < nums[mid]){
                if (target > nums[end] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            }else {
                if (target > nums[mid] && target <= nums[end]) start = mid+1;
                else end = mid - 1;
            }
        }
        if (start == end && nums[start] == target) return start;
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2};
        int t = 0;
        System.out.println(new SearchInRotatedSortedArray().search(a,t));
    }

}
