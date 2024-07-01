class Solution{
    int maxG = 0;
    int[] rowmove = {1, -1, 0, 0};  //use for check neighbor
    int[] colmove = {0, 0, 1, -1};  //use for check neighbor
    private int dfs(int[][] grid, int x, int y, int colLength, int rowLength){
        if (x < 0 || y < 0 || x >= rowLength || y >= colLength || grid[y][x] == 0) return 0;    //check 0 and unexpected situation
        
        int now = grid[y][x];   //current cell's gold amount
        int get = now;  //get is the total gold now we get
        grid[y][x] = 0; //mark the current cell as visited by setting its value to 0

        //use to check four neighbor recursively
        for(int i = 0; i < 4; i++){
            int newY = y + rowmove[i];
            int newX = x + colmove[i];
            get = Math.max(get, now + dfs(grid, newX, newY, colLength, rowLength));
        }

        grid[y][x] = now;   //restore the current cell's gold amount for future exploration
        return get;
    }
    public int getMaximumGold(int[][] grid){
        int colLength = grid.length, rowLength = grid[0].length;

        for(int i = 0; i < colLength; i++){
            for(int j = 0; j < rowLength; j++){
                maxG = Math.max(maxG, dfs(grid, j, i, colLength, rowLength));
            }
        }

        return maxG;
    }
}
