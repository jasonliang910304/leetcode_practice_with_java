class Solution{
    public int[][] largestLocal(int[][] grid){
        int[][] maxLocal = new int[grid.length - 2][grid[0].length - 2];
        
        for (int i = 1; i < grid.length - 1; i++){
            for(int j = 1; j < grid[0].length - 1; j++){
                int max = 0;

                for (int k = i - 1; k <= i + 1; k++){
                    for(int l = j - 1; l <= j + 1; l++){
                        if(grid[k][l] > max){
                            max = grid[k][l];
                        }
                    }
                }
                maxLocal[i - 1][j - 1] = max;
            }
        }
        return maxLocal;
    }
}
