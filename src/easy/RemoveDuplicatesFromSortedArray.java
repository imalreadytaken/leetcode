package easy;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 0) return 0;
        int len = 0, tmp = nums[0] + 1, cursor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tmp != nums[i]){
                len++;
                tmp = nums[i];
                nums[cursor++] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a  ={0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
        System.out.println(r.removeDuplicates(a));
        System.out.println(a);
    }

}
