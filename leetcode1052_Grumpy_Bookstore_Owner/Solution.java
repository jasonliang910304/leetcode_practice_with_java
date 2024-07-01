class Solution{
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes){
        int max = 0;
        int musthappy = 0;
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 0){
                musthappy += customers[i];
            }
        }

        for(int i = 0; i <= customers.length - minutes; i++){
            int happycount = 0;
            for(int j = i; j < minutes + i; j++){
                if(grumpy[j] == 1){
                    happycount += customers[j];
                }
            }
            max = Math.max(max, happycount);
        }
        return max + musthappy;
    }
}
