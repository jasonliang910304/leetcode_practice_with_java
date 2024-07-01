import java.util.HashSet;

class Solution {
    private boolean check(HashSet<Integer> subset, int k, int num) {
        return !subset.contains(num - k) && !subset.contains(num + k);
    }

    public int beautifulSubsets(int[] nums, int k) {
        int count = 0;
        int n = 1 << nums.length;

        for (int i = 1; i < n; i++) {
            HashSet<Integer> subset = new HashSet<>();
            boolean isBeautiful = true;

            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    if (!check(subset, k, nums[j])) {
                        isBeautiful = false;
                        break;
                    }
                    subset.add(nums[j]);
                }
            }

            if (isBeautiful) {
                count++;
            }
        }
        return count;
    }
}
