class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Initialize the boundaries
        int colbegin = 0;
        int colend = matrix[0].length - 1;
        int rowbegin = 0;
        int rowend = matrix.length - 1;
        
        List<Integer> result = new ArrayList<>();
        
        while (colbegin <= colend && rowbegin <= rowend) {
            
            // Traverse right
            for (int j = colbegin; j <= colend; j++) {
                result.add(matrix[rowbegin][j]);
            }
            rowbegin++;  // Move the top boundary down
            
            // Traverse down
            for (int i = rowbegin; i <= rowend; i++) {
                result.add(matrix[i][colend]);
            }
            colend--;  // Move the right boundary left
            
            // Traverse left
            if (rowbegin <= rowend) {
                for (int j = colend; j >= colbegin; j--) {
                    result.add(matrix[rowend][j]);
                }
                rowend--;  // Move the bottom boundary up
            }
            
            // Traverse up
            if (colbegin <= colend) {
                for (int i = rowend; i >= rowbegin; i--) {
                    result.add(matrix[i][colbegin]); 
                }
                colbegin++;  // Move the left boundary right
            }
        }
        
        return result;
    }
}
