package easy;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int cur = n + m - 1, cur1 = m - 1, cur2 = n - 1;
        while (cur1 >= 0 && cur2 >= 0){
            if (nums1[cur1] >= nums2[cur2])
                nums1[cur--] = nums1[cur1--];
            else
                nums1[cur--] = nums2[cur2--];
        }

        while (cur1>=0)
            nums1[cur--] = nums1[cur1--];

        while (cur2 >= 0)
            nums1[cur--] = nums2[cur2--];

    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,4,6,0,0};
        int[] nums2 = {2,5};
        new MergeSortedArray().merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
    }

}
