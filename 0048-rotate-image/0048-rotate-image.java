class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        int colsize = matrix[0].length - 1;
        for(int i = 0; i < matrix.length; i++) {
            int j = 0;
            int k = colsize;
            while(j < k) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }
        // return matrix;
    }
    
    
    private void transpose(int[][] matrix) {
        for(int i = 0; i < matrix[0].length; i++) {
            for(int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}