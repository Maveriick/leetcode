class Orange {
    int x;
    int y;
    public Orange(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    public int orangesRotting(int[][] grid) {
        int[] xDirs = new int[]{-1,1,0,0};
        int[] yDirs = new int[]{0,0,1,-1};
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][]visited = new boolean[rows][cols];
        Queue<Orange> bfsQ = new LinkedList<>();
        int min = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] ==  2){
                    Orange rotten = new Orange(i,j);
                    bfsQ.add(rotten);
                    visited[i][j] = true;
                }
            }
        }
        
        while(!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            for(int i = 0; i < size; i++) {
                Orange current = bfsQ.remove();
                int currentX = current.x;
                int currentY = current.y;
                for(int j = 0; j < 4; j++) {
                    int newX = currentX + xDirs[j];
                    int newY = currentY + yDirs[j];
                    if(newX >= 0 && newX < rows && newY >= 0 && newY < cols){
                        if(grid[newX][newY] == 1 && visited[newX][newY] == false){
                            Orange nextRotten = new Orange(newX, newY);
                            visited[newX][newY] = true;
                            bfsQ.add(nextRotten);
                        }
                    }
                }
            }
            min++;
        }
        
         for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] ==  1 && visited[i][j] == false){
                    return -1;
                }
            }
        }
        
        return min > 0 ? min - 1 : 0;
        
        
        
        
        
    }
    
    
}