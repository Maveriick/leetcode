class Solution {
    int[] xDirs = new int[]{-1,1,0,0};
    int[] yDirs = new int[]{0,0,-1,1};
    
    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxGold = 0;
        boolean[][] visited;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] != 0) {
                    visited = new boolean[rows][cols];
                    int goldAtPosition = dfs(grid, i, j, rows, cols, visited);
                    maxGold = Math.max(maxGold, goldAtPosition);
                }
            }
        }
        return maxGold;
    }
    
    /*
    [[0,6,0],
     [5,8,7],
     [0,9,0]]
     */
    
    private int dfs(int[][] grid, int currentX, int currentY, int rows, int cols, boolean[][] visited) {
        visited[currentX][currentY] = true;
        int currentGold = grid[currentX][currentY];
        
        for(int i = 0; i < 4; i++){
            int newX = currentX + xDirs[i];
            int newY = currentY + yDirs[i];
            if(newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                if(visited[newX][newY] == false && grid[newX][newY] != 0) {
                    currentGold = Math.max(currentGold, dfs(grid, newX, newY, rows, cols, visited) + grid[currentX][currentY]);
                }
            }
        }
        
        visited[currentX][currentY] = false;
        return currentGold;
    }
}