class Solution {
    int[] xDirs = new int[]{-1,1,0,0};
    int[] yDirs = new int[]{0,0,-1,1};
    boolean[][] visited;
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0 || i == rows - 1 || j == 0 || j == cols -1) {
                    if(board[i][j] == 'O' && visited[i][j] == false){
                        dfs(board, visited, i, j, rows, cols);
                    }
                }
            }
        }
        
        
        for(int i = 0; i < rows; i++){
            System.out.println(Arrays.toString(board[i]));
        }
        
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
               if(board[i][j] == 'A'){
                   board[i][j] = 'O';
               } else {
                   board[i][j] = 'X';
               }
            }
        }
    }
    
    
    private void dfs(char[][] board, boolean[][] visited, int currentX, int currentY, int rows, int cols){
       
        visited[currentX][currentY] = true;
        board[currentX][currentY] = 'A';
        for(int i = 0; i < 4; i++){
            int newX = currentX + xDirs[i];
            int newY = currentY + yDirs[i];
            if(newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                if(board[newX][newY] == 'O' && visited[newX][newY] == false){
                    dfs(board, visited, newX, newY, rows, cols);
                }
            }
        }
    }
}