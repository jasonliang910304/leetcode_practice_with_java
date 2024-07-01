import java.util.*;
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int counter = 0, pointer = happiness.length;
        long sum = 0;
        while(k > 0){
            if (happiness[pointer - 1] - counter <= 0)
                break;
            sum += happiness[pointer - 1] - counter;
            pointer--;
            counter++;
            k--;
        }
        return sum;
    }
}
