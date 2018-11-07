package medium;

/**
 *Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,1,2,3,3],
 *
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {

        int cur = 1, index = 1;
        while (index < nums.length){
            nums[cur++] = nums[index++];
            while (index < nums.length && nums[index] == nums[cur - 2])
                index++;
        }

        return cur > nums.length ? nums.length : cur;
    }

//    public int removeDuplicates(int[] nums) {
//
//        if (nums.length <= 2)
//            return nums.length;
//
//        int cur = 1, current = nums[0], dup = 1;
//
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == current){
//                if (dup++ < 2){
//                    // 可以移动并增加计数
//                    nums[cur++] = nums[i];
//                }
//            }else {
//                // 重置计数，并移动元素
//                dup = 1;
//                current = nums[i];
//                nums[cur++] = nums[i];
//            }
//        }
//
//        return cur;
//    }

}
