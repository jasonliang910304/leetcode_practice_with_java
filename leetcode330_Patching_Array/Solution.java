class Solution{
    public int minPatches(int[] nums, int n){
        int ret = 0;
        int i = 0;
        long miss = 0;
        while (miss <= n) {
            if(i < nums.length && nums[i] <= miss){
                miss += nums[i];
                i++;
            }
            else{
                miss += miss;
                ret++;
            }
        }
        return ret;
    }
}
