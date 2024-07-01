import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> ret = new ArrayList<>();
        int totalsubset = 1 << nums.length;
        for(int i = 0; i < totalsubset; i++){
            int k = 0;
            List<Integer> subset = new ArrayList<>();
            for(int j = i; j > 0; j /= 2){
                if(j % 2 == 1){
                    subset.add(nums[k]);
                }
                k++;
            }
            ret.add(subset);
        }
        return ret;
    }
}
