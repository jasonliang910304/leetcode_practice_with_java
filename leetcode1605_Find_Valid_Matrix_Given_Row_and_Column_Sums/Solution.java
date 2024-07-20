public class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ret = new int[rowSum.length][colSum.length];
        int i = 0, j = 0;

        while (i < rowSum.length && j < colSum.length) {
            ret[i][j] = Math.min(rowSum[i], colSum[j]);
            rowSum[i] -= ret[i][j];
            colSum[j] -= ret[i][j];
            if (rowSum[i] == 0) {
                i++;
            }
            else if (colSum[j] == 0){
                j++;
            }
        }
        return ret;
    }
}
