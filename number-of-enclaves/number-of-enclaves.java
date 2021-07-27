class Solution {
    boolean[][] visited;
    int[] xDirs = new int[] {-1,1,0,0};
    int[] yDirs = new int[] {0,0,-1,1};
    
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++) {
                if(i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    if(visited[i][j] == false && grid[i][j] == 1) {
                        dfs(grid, rows, cols, i, j);
                    }
                }
            }
        }
        
        int sol = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++) {
                    if(grid[i][j] == 1) {
                        sol++;
                    }
            }
        }
        
        return sol;
    }
    
    
    private void dfs(int[][] grid, int rows, int cols, int currentX, int currentY) {
        grid[currentX][currentY] = 0;
        visited[currentX][currentY] = true;
        for(int i = 0; i < 4; i++) {
            int newX = currentX + xDirs[i];
            int newY = currentY + yDirs[i];
            if(newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                if(visited[newX][newY] == false && grid[newX][newY] == 1){
                    dfs(grid, rows, cols, newX, newY);
                }
            }
        }
    }
}