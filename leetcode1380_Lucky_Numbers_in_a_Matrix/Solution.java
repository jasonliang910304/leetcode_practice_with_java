import java.util.*;
public class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        List<Integer> rowmin = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            int rmin = Integer.MAX_VALUE;
            for (int j = 0; j < cols; j++) {
                rmin = Math.min(rmin, matrix[i][j]);
            }
            rowmin.add(rmin);
        }

        List<Integer> colmax = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            int cmax = Integer.MIN_VALUE;
            for (int j = 0; j < rows; j++) {
                cmax = Math.max(cmax, matrix[j][i]);
            }
            colmax.add(cmax);
        }

        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == rowmin.get(i) && matrix[i][j] == colmax.get(j)) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }
        return luckyNumbers;
    }
}
