class Point{
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int hashCode() {
        return 7 * x + 23 * y + 37;
    }
    
    
    @Override
    public boolean equals(Object o) {
        Point other = (Point) o;
        return this.x == other.x && this.y == other.y;
    }
}
class Solution {
    int[] xDirs = new int[]{-1,1,0,0};
    int[] yDirs = new int[]{0,0,-1,1};
    
    public int getFood(char[][] grid) {
        Queue<Point> bfsQ = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        Set<Point> visited = new HashSet<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '*'){
                    Point start = new Point(i, j);
                    bfsQ.add(start);
                    visited.add(start);
                }
            }
        }
        
        int distance = 0;
        while(!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            for(int i = 0; i < size; i++){
                Point next = bfsQ.remove();
                int x = next.x;
                int y = next.y;
                if(grid[x][y] == '#'){
                    return distance;
                } else{
                    for(int j = 0; j < 4; j++) {
                        int newX = x + xDirs[j];
                        int newY = y + yDirs[j];
                        if(newX >=  0 && newX < rows && newY >= 0 && newY < cols){
                            if(grid[newX][newY] != 'X'){
                                Point possible = new Point(newX, newY);
                                if(!visited.contains(possible)){
                                    visited.add(possible);
                                    bfsQ.add(possible);
                                }
                            }
                        }
                    }
                }
            }
             distance++;
        }
        
        
        
        return -1;
    }
}