class Solution{
    public boolean judgeSquareSum(int c){
        long root = 0, l = 1, r = c;
        while(l <= r){
            long mid = l + (r - l) / 2;
            long square = mid * mid;
            if(square == c) return true;
            if(square > c){
                r = mid - 1;
            }
            else{
                root = mid;
                l = mid + 1;
            }
        }
        l = 0;
        r = root;
        while(l <= r){
            long square = l * l + r * r;
            if(square == c) return true;
            if(square > c){
                r--;
            }
            else{
                l++;
            }
        }
        return false;
    }
}
