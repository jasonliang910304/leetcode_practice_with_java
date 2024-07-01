import java.util.*;;
class Solution {
    public int matrixScore(int[][] grid){
        int row = grid.length, col = grid[0].length;
        int ans = (1 << (col - 1)) * row;

        for(int j = 1; j < col; j++){
            int val = 1 << (col - 1 - j);
            int set = 0;
            for(int i = 0; i < row; i++){
                if(grid[i][j] == grid[i][0]){
                    set++;
                }
            }
            ans += Math.max(set, row - set) * val;
        }
        return ans;
    }
}
