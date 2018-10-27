package interview.bytedance;

public class TopKth {

    public double getKth(double[] nums, int K){
        int low = 0, n = nums.length, high = n - 1, cur = n - 1;
        int lastHigh = n - 1, lastLow = 0;
        while(cur != n - K){

            if(cur > n - K){
                high = cur;
                low = lastLow;
            }
            if(cur < n - K){
                low = cur;
                high = lastHigh;
            }
            double tmp = nums[cur];
            while(low < high){
                while(low < high && nums[low] <= tmp)
                low++;
                nums[cur] = nums[low];
                cur = low;
                while(high > low && nums[high] >= tmp)
                    high--;
                nums[cur] = nums[high];
                cur = high;
            }
            cur = low;
        }
        return nums[cur];

    }

}
