class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        
        for(int i = 0; i < cols; i++){
            dp[0][i] = matrix[0][i];
        }
        
        int[] ways = new int[]{-1,0,1};
        
        for(int i = 1; i < rows; i++) {
            for(int j = 0; j < cols ; j++) {
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < ways.length; k++) {
                    if(j + ways[k] < cols && j + ways[k] >= 0) {
                         min = Math.min(min, dp[i - 1][j + ways[k]] + matrix[i][j]);
                    }
                }
                dp[i][j] = min;
            }
        }
    
        
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < cols; i++) {
            minSum = Math.min(minSum, dp[rows - 1][i]);
        }
        return minSum;
    }
}


/*

[[17,82],
[1,-44]]

*/