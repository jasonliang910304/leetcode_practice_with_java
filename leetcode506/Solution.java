import java.util.*;
class Solution {
    pubilc String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] sortedscore = new Integer[n];
        HashMap<Integer, String> rank = new HashMap<>();

        for (int i = 0; i < score.length; i++){
            sortedscore[i] = score[i];
        }
        Arrays.sort(sortedscore, Collections.reverseOrder());
        for (int i = 0; i < sortedscore.length; i++){
            if (i == 0){
                rank.put(sortedscore[i], "Gold Medal");
            }
            else if (i == 1){
                rank.put(sortedscore[i], "Silver Medal");
            }
            else if (i == 2){
                rank.put(sortedscore[i], "Bronze Medal");
            }
            else{
                rank.put(sortedscore[i], Integer.toString(i + 1));
            }
        }
        String[] ans = new String[n];
        for (int i = 0; i < sortedscore.length; i++){
            ans[i] = rank.get(score[i]);
        }
        return ans;
    }
}
