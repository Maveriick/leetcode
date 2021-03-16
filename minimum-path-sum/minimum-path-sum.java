class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] pathMin = new int[rows][cols];
        //Set first row
        
        for(int i = 0; i < cols; i++) {
            if(i == 0){
                pathMin[0][i] = grid[0][i];
            } else {
                pathMin[0][i] = pathMin[0][i - 1] + grid[0][i];
            }
        }
        
        //Set first col
        for(int i = 0; i < rows; i++) {
            if(i == 0){
                pathMin[i][0] = grid[i][0];
            } else {
                pathMin[i][0] = pathMin[i-1][0] + grid[i][0];
            }
        }
        
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                pathMin[i][j] = Math.min(pathMin[i-1][j], pathMin[i][j-1]) + grid[i][j];
            }
        }
        
        return pathMin[rows - 1][cols - 1];
    }
}