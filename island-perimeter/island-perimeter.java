class Solution {
    public int islandPerimeter(int[][] grid) {
        int[] xDirs = new int[] {-1,1,0,0};
        int[] yDirs = new int[]{0,0,-1,1};
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int perimeter = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1 ) {
                    int p = 4;
                   
                    for(int k = 0; k < 4; k++) {
                        int xDir = i + xDirs[k];
                        int yDir = j + yDirs[k];

                        if(xDir >= 0 && xDir < grid.length && yDir >= 0 && yDir < grid[i].length){
                            if(grid[xDir][yDir] == 1){
                                p --;
                            }
                        }
                    }
                    
                    perimeter += p;
                }
            }
        }
        return perimeter;
    }
}