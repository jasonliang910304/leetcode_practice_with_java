import java.util.Arrays;

/**
 * Solution
 */
public class Solution {
    public int heightChecker(int[] heights){
        int[] expected = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
            expected[i] = heights[i];
        }
        int count = 0;
        Arrays.sort(expected);
        for(int i = 0; i < heights.length; i++){
            count += heights[i] != expected[i] ? 1 : 0;
        }
        return count;
    }
}
