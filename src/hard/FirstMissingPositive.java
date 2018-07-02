package hard;

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
