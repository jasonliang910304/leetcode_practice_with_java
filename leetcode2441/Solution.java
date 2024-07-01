import java.util.*;
class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> negative = new HashSet<>() ;
        int max = -1;
        for(int num : nums) {
            if (num < 0)
                negative.add(num);
        }
        for(int num : nums) {
            if (negative.contains(num * -1) && num > max) {
                max = num;
            }
        }
        return max;
    }
}
