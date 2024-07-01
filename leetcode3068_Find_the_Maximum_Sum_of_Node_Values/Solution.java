class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges){
        long sum = 0;
        int minpos = Integer.MAX_VALUE;
        int maxneg = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            int numxor = nums[i] ^ k;
            int diff = numxor - nums[i];
            if (diff > 0){
                sum += diff;
                minpos = Math.min(minpos, diff);
                count++;
            }
            else{
                maxneg = Math.max(maxneg, diff);
            }
        }
        if(count % 2 == 0){
            return sum;
        }
        else{
            sum += minpos > maxneg ? maxneg : -minpos;
            return sum;
        }

    }
}
