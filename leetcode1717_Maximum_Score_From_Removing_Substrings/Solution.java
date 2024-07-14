package leetcode1717_Maximum_Score_From_Removing_Substrings;

/**
 * Solution
 */
public class Solution {

    public int maximumGain(String s, int x, int y) {
        int ret = 0;
        int countA = 0;
        int countB = 0;
        int less = Math.min(x, y);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch > 'b') {
                ret += Math.min(countA, countB) * less;
                countA = 0;
                countB = 0;
            }
            else if (ch == 'a') {
                if (x < y && countB > 0) {
                    countB--;
                    ret += y;
                }
                else{
                    countA++;
                }
            }
            else{
                if (x > y && countA > 0) {
                    countA--;
                    ret += x;
                }
                else {
                    countB++;
                }
            }
        }
        ret += Math.min(countA, countB) * less;
        return ret;
    }
}
