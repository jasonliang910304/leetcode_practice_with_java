package leetcode1190_Reverse_Substrings_Between_Each_Pair_of_Prentheses;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Solution
 */
public class Solution {

    public String reverseParentheses(String s){
        Stack<Integer> openParenthesesIndices = new Stack<>();
        int[] pair = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openParenthesesIndices.push(i);
            }
            if (s.charAt(i) == ')'){
                int j = openParenthesesIndices.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder ret = new StringBuilder();
        for(int currindex = 0, direction = 1; currindex < s.length(); currindex += direction){
            if(s.charAt(currindex) == '(' || s.charAt(currindex) == ')'){
                currindex = pair[currindex];
                direction = -direction;
            }
            else{
                ret.append(s.charAt(currindex));
            }
        }
        return ret.toString();
    }
}
