class Point{
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object o){
        Point other = (Point) o;
        return other.x == this.x && other.y == this.y;
    }
    
    @Override
    public int hashCode() {
        return 7 * this.x * 13 * this.y;
    }
    
    @Override
    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }
}

class Solution {
   int[] xDirs = new int[]{-1,-1,-1,1,1,1,0,0};
    int[] yDirs = new int[]{-1,0,1,-1,0,1,-1,1};
    
    int distance = 1;
    boolean[][] visited ;
    
    public int shortestPathBinaryMatrix(int[][] grid) {
    
        int rows = grid.length;
        int cols = grid[0].length;
        visited = new boolean[rows][cols];
        visited[0][0] = true;
        if(grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1){
            return -1;
        }
        
        Queue<Point> bfsQ = new LinkedList<>();
        Point start = new Point(0,0);
        bfsQ.add(start);
        while(!bfsQ.isEmpty()) {
            int size = bfsQ.size();
           
            for(int i = 0; i < size; i++) {
                Point current = bfsQ.remove();
                int currentX = current.x;
                int currentY = current.y;

                if(currentX == rows - 1 && currentY == cols - 1){
                    return distance;
                }
                for(int j = 0; j < 8; j++) {
                    int newX = currentX + xDirs[j];
                    int newY = currentY + yDirs[j];
                    if(newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                        Point possible = new Point(newX, newY);
                        if(grid[newX][newY] == 0 && visited[newX][newY] == false){
                            bfsQ.add(possible);
                             visited[newX][newY] = true;
                        }
                    }
                }
            }
            distance ++;  
        }
        
        return -1;
    }
}




/*
[[0,0,0],
[0,1,0],
[0,0,0]]

*/









