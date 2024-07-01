class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int counter1 = 0, counter2 = 0;
        while(counter1 < nums1.length && counter2 < nums2.length){
            if (nums1[counter1] > nums2[counter2]){
                counter2++;
            }
            else if (nums1[counter1] < nums2[counter2])
                counter1++;
            else if (nums1[counter1] == nums2[counter2])
                return nums1[counter1];
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums1 = {1,2,8,12,32,34,43,52,57,62,64,67,71,71,79,81,86,91,93,94};
        int[] nums2 = {9,11,12,14,19,25,29,31,38,39,41,42,58,63,66,70,71,73,91,91};
        int[] nums3 = {1, 3, 4, 6};
        int[] nums4 = {2, 3, 4, 5};
        Solution ans1 = new Solution();
        Solution ans2 = new Solution();
        System.out.print(ans1.getCommon(nums1, nums2) + "\n");
        System.out.print(ans2.getCommon(nums3, nums4));
    }
}
