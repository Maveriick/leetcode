class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for(int i = 0; i < cols; i++) {
            dp[0][i] = matrix[0][i];
        }
        
        for(int i = 1; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if( j > 0 && j < cols - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i-1][j-1] ,dp[i-1][j+1]), dp[i-1][j]);
                } else if( j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j+1], dp[i-1][j]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }
        
       
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < cols; i++) {
            minSum = Math.min(minSum, dp[rows-1][i]);
        }
        return minSum;
    }
}