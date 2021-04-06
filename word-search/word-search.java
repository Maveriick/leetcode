class Solution {
    int[] xDirs = new int[]{-1,1,0,0};
    int[] yDirs = new int[]{0,0,-1,1};
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited;
        if(word.length() == 0) {
            return false;
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    visited = new boolean[rows][cols];
                    if(dfs(visited, board, word, 1, i, j, rows, cols)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /*
    [["A","B","C","E"],
    ["S","F","E","S"],
    ["A","D","E","E"]]
    
    
    */
    
    private boolean dfs(boolean[][] visited, char[][] board, String word, int currentIndex, int currentX, int currentY, int rows, int cols) {
        if(currentIndex >= word.length()){
            return true;
        }
        visited[currentX][currentY] = true;
        boolean isPresent = false;
        for(int i = 0; i < 4; i++){
            int newX = currentX + xDirs[i];
            int newY = currentY + yDirs[i];
            if(newX >=0 && newX < rows && newY >=0 && newY < cols){
                if(visited[newX][newY] == false && board[newX][newY] == word.charAt(currentIndex)){
                    isPresent = isPresent || dfs(visited, board, word, currentIndex + 1, newX, newY, rows, cols);
                }
            }
        }
        visited[currentX][currentY] = false;
        return isPresent;
    }
}