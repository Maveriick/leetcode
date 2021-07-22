class Solution {
     int[] xDirs = new int[]{-1,-1,-1,1,1,1,0,0};
     int[] yDirs = new int[]{-1,0,1,-1,0,1,-1,1};
    int[][] sol;
    public void gameOfLife(int[][] board) {
       int rows = board.length;
        int cols = board[0].length;
        sol = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int current = board[i][j];
                int liveNeighbours = 0;
               
                for(int k = 0; k < 8; k++) {
                    int newX = i + xDirs[k];
                    int newY = j + yDirs[k];
                    if(newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                        if(board[newX][newY] == 1){
                            liveNeighbours++;
                        }
                    }
                }
               
                if(current == 1){
                    if(liveNeighbours < 2 || liveNeighbours > 3){
                        sol[i][j] = 0;
                    } else {
                        sol[i][j] = 1;
                    }
                } else {
                    if(liveNeighbours == 3) {
                        sol[i][j] = 1;
                    } else {
                        sol[i][j] = 0;
                    }
                }
            }
        }
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                board[i][j] = sol[i][j];
            }
        }
    }
}