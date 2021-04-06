class Solution {
  
    boolean[][] visited;
    int[] xDirs = new int[]{-1,1,0,0};
    int[] yDirs = new int[]{0,0,-1,1};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols =  grid[0].length;
        visited = new boolean[rows][cols];
        int components = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    components++;
                    dfs(i, j, visited, rows, cols, grid);
                }
            }
        }
        return components;
    }
    
    
    private void dfs(int currentX, int currentY, boolean[][] visited, int rows, int cols, char[][]grid){
        visited[currentX][currentY] = true;
        for(int i = 0; i < 4; i++){
            int newX = currentX + xDirs[i];
            int newY = currentY + yDirs[i];
            if(newX >= 0 && newX < rows && newY >= 0 && newY < cols){
                if(visited[newX][newY] == false && grid[newX][newY] == '1'){
                    dfs(newX, newY, visited, rows, cols, grid);
                }
            }
        }
    }
}