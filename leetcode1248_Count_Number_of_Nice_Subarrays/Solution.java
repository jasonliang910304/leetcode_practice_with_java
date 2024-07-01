import java.util.HashMap;

class Solution{
    public int numberOfSubarrays(int[] nums, int k){
        int sum = 0;
        int ret = 0;

        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        for(int num : nums){
            sum += num % 2;
            if(prefixSum.containsKey(sum - k)){
                ret += prefixSum.get(sum - k);
            }

            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }
}
