class Solution {
    public void rotate(int[][] matrix) {
        // Step 1: Transpose the matrix
        transpose(matrix);
        
        // Step 2: Reverse each row
        int colSize = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            int j = 0;
            int k = colSize;
            while (j < k) {
                // Swap the elements at the start and end of the row
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }
    }
    
    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                // Swap the elements across the diagonal
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
