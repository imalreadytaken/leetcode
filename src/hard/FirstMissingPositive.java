package hard;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length, tmp;
        if (n <= 0) return 1;
        int i = 0;
        while (i < n){
            while (nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i]){
                tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
            i++;
        }
        for (int j = 0; j < n; j++) if (nums[j] != j + 1) return j + 1;
        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();
        int[] a = {1,2,3,4,5,6};
        System.out.println(f.firstMissingPositive(a));
    }

}
