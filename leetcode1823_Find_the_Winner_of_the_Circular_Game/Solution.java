public class Solution {
    public int findTheWinner(int n, int k) {
        int alive = 0;
        for (int i = 2; i <= n; i++) {
            alive = (alive + k) % i;
        }
        return alive + 1;
    }
}
