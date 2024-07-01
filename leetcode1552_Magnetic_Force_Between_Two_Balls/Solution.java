import java.util.Arrays;

class Solution{
    public int maxDistance(int[] position, int m){
        Arrays.sort(position);
        int possiblemax = position[position.length - 1];
        int l = 0, r = possiblemax;
        int answer = 0;

        while(l <= r){
            int mid = l + (r - l) / 2;
            if(check(position, mid, m)){
                answer = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return answer;
    }

    private boolean check(int[] position, int mid, int m){
        int start = position[0];
        int ballcount = 1;
        for(int i = 1; i < position.length && ballcount < m; i++){
            int now = position[i];
            if(now - start >= mid){
                ballcount += 1;
                start = now;
            }
        }

        return ballcount == m;
    }
}
