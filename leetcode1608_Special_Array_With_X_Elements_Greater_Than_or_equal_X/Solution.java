import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        if(nums[0] >= n) return n;
        for(int i = 0; i <= n; i++){
            if(nums[n - i] >= i && (n - i - 1 < 0 || nums[n - i - 1] < i)){
                return i;
            }
        }
        return -1;
    }
}
