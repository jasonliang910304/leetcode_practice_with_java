import java.util.*;
class Solution{
    public List<String> wordBreak(String s, List<String> wordDict){
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        backtrack(s, wordSet, new StringBuilder(), result, 0);
        return result;
    }
    private void backtrack(
        String s, 
        Set<String>wordSet, 
        StringBuilder currentSentance, 
        List<String> results, 
        int startIndex
    ){
        if (startIndex == s.length()){
            results.add(currentSentance.toString().trim());
            return;
        }

        for(int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++){
            String word = s.substring(startIndex, endIndex);
            if(wordSet.contains(word)){
                int currentLength = currentSentance.length();
                currentSentance.append(word).append(" ");
                backtrack(s, wordSet, currentSentance, results, endIndex);
                currentSentance.setLength(currentLength);
            }
        }
    }
}
