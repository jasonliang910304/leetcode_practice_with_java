import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> item = new HashMap<>();
        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++){
            if(item.containsKey(s.charAt(right))){
                if (left <= item.get(s.charAt(right))){
                    left = item.get(s.charAt(right)) + 1;
                }
            }
            item.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
