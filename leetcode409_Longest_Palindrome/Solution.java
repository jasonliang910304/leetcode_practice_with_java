import java.util.HashSet;

class Solution {
    public int longestPalindrome(String s){
        int ret = 0;
        HashSet<Character> alphabet = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            if(alphabet.contains(s.charAt(i))){
                alphabet.remove(s.charAt(i));
                ret += 2;
            }
            else{
                alphabet.add(s.charAt(i));
            }
        }
        return ret < s.length() ? ret + 1 : ret;
    }
}
