class Solution {
    int[] xDirs = new int[]{-1,1,0,0};
    int[] yDirs = new int[]{0,0,-1,1};
    StringBuilder sb;
     boolean[][] visited ;
    public int numDistinctIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        Set<String> currentIslands = new HashSet<>();
       visited = new boolean[rows][cols];
       
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(visited[i][j] == false && grid[i][j] == 1) {
                    
                    sb = new StringBuilder();
                    dfs(grid, rows, cols, i, j);
                    System.out.println(sb.toString());
                    currentIslands.add(sb.toString());
                }
            }
        }
        
        return currentIslands.size();
    }
    
    /*
    [1,1,0],
    [0,1,1],
    [0,0,0],
    [1,1,1],
    [0,1,0]
    
    
    */
    
    
    private void dfs(int[][] grid, int rows, int cols, int currentX, int currentY) {
        visited[currentX][currentY] = true;
        for(int i = 0; i < 4; i++) {
            int newX = currentX + xDirs[i];
            int newY = currentY + yDirs[i];
            if(newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                if(visited[newX][newY] == false && grid[newX][newY] == 1) {
                    if(i == 0) {
                        sb.append("L");
                    } else if(i == 1) {
                        sb.append("R");
                    } else if( i == 2) {
                        sb.append("U");
                    } else {
                        sb.append("D");
                    }
                    dfs(grid, rows, cols, newX, newY);
                }
            }
            sb.append("#");
        }
    }
}