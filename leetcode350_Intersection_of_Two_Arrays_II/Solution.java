import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int pointer1 = 0;
        int pointer2 = 0;

        LinkedList<Integer> ret = new LinkedList<>();
        while(pointer1 < nums1.length && pointer2 < nums2.length){
            if(nums1[pointer1] == nums2[pointer2]){
                ret.add(nums1[pointer1]);
                pointer1++;
                pointer2++;
            }
            else if(nums1[pointer1] > nums2[pointer2]){
                pointer2++;
            }
            else if(nums2[pointer2] > nums1[pointer1]){
                pointer1++;
            }
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}
