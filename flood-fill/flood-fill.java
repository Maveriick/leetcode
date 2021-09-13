class Solution {
    int[] xDirs = new int[]{-1,1,0,0};
    int[] yDirs = new int[]{0,0,-1,1};
    boolean[][] visited;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        visited = new boolean[rows][cols];
        dfs(image, sr, sc, newColor, image[sr][sc], rows, cols, visited);
        return image;
    }
    
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int existingColor, int rows, int cols, boolean[][] visited) {
        visited[sr][sc] = true;
        image[sr][sc] = newColor;
        for(int i = 0; i < 4; i++) {
                int newX = sr + xDirs[i];
                int newY = sc + yDirs[i];
                if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && visited[newX][newY] == false && image[newX][newY] == existingColor) {
                    dfs(image, newX, newY, newColor, existingColor, rows, cols, visited);
                }
        }
    }
}

/*
[[2,2,1],
[2,2,0],
[2,0,1]]


[[2,2,2],
 [2,2,0],
 [2,0,1]]
 */