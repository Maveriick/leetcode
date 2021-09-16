class Solution {
    int[] xDirs = new int[]{-1,-1,-1,1,1,1,0,0};
    int[] yDirs = new int[]{-1,0,1,-1,0,1,-1,1};
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        getNextState(board, board.length, board[0].length);
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++){
                if(board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private void getNextState(int[][] board, int rows, int cols) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                
                int liveNeighbours = 0;
                for(int k = 0; k < 8; k++) {
                    int newX = i + xDirs[k];
                    int newY = j + yDirs[k];
                    if(newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                        if(Math.abs(board[newX][newY]) == 1) {
                            liveNeighbours ++;
                        }
                    }
                }
                
                if(board[i][j] == 1) {
                    // Cell is live
                    if(liveNeighbours < 2 || liveNeighbours > 3){
                        board[i][j] = -1;
                    } 
                    
                } else {
                    // Cell is dead
                   if(liveNeighbours == 3){
                        board[i][j] = 2;
                    } 
                }
            }
        }
    }
}

/*
[[0,1,0],
[1,0,1],
[0,1,1],
[0,1,0]]


*/


