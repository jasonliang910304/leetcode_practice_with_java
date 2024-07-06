public class Solution {
    public int passThePillow(int n, int time){
        int direction = time / (n - 1);
        int who = time % (n - 1);
        return direction % 2 == 1 ? n - who : 1 + who;
    }
}
