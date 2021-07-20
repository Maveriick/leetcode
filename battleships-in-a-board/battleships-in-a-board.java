class Solution {
    boolean[][] visited;
    int battleShips = 0;
    int[] xDirs = new int[]{-1,1,0,0};
    int[] yDirs = new int[]{0,0,1,-1};
    public int countBattleships(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++) {
                if(visited[i][j] == false && board[i][j] == 'X') {
                    battleShips++;
                    dfs(board, i, j, rows, cols);
                }
            }
        }
        return battleShips;
    }
    
    private void dfs(char[][] board, int currentX, int currentY, int rows, int cols) {
        visited[currentX][currentY] = true;
        for(int i = 0; i < 4; i++) {
            int newX = currentX + xDirs[i];
            int newY = currentY + yDirs[i];
            if(newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                if(visited[newX][newY] == false && board[newX][newY] == 'X') {
                    dfs(board, newX, newY, rows, cols);
                }
            }
        }
    }
}