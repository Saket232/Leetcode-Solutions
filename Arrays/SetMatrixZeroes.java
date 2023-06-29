package Arrays;

/*  Brute force Approach
Complexity
Time complexity:O((NM)(N + M)) + O(N*M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
Space complexity:O(1)
*/

public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes solution = new SetMatrixZeroes();
        int matrix[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        solution.setZeroes(matrix);
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // 1. mark rows as -10000000 if value is 0
                    markrows(matrix, j, m);
                    // 2. mark columns as -10000000 if value is 0
                    markcolumns(matrix, i, n);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -10000000) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void markrows(int[][] matrix, int a, int m) {
        for (int j = 0; j < m; j++) {
            // ignore if value is 0
            if (matrix[j][a] == 0) {
                continue;
            }
            matrix[j][a] = -10000000;
        }
    }

    private void markcolumns(int[][] matrix, int a, int n) {
        for (int j = 0; j < n; j++) {
            // ignore if value is 0
            if (matrix[a][j] == 0) {
                continue;
            }
            matrix[a][j] = -10000000;
        }
    }

}