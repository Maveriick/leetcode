class Point{
    int x;
    int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int hashCode() {
        return this.x * 31 * this.y * 37;
    }
    
    @Override
    public boolean equals(Object other) {
        Point o = (Point) other;
        return this.x == o.x && this.y == o.y;
    }
}
class Solution {
    boolean canVisit = false;
    int[] xDirs = new int[]{-1,1,0,0};
    int[] yDirs = new int[] {0,0,-1,1};
    
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start[0], start[1], destination[0], destination[1], new HashSet<>());
    }
    
    
    
    
    private boolean dfs(int[][] maze, int startX, int startY, int endX, int endY, Set<Point> visited) {
        if(canVisit == true) {
            return true;
        }
        if(startX == endX && startY == endY) {
            return true;
        }
        
        Point p = new Point(startX,startY);
        visited.add(p);
        boolean canReach = false;
        for(int i = 0; i < 4; i++) {
            if(canVisit == true) {
                continue;
            }
            int currentX = startX;
            int currentY = startY;
            int nextX = xDirs[i];
            int nextY = yDirs[i];
            
            while(currentX + nextX >= 0 && currentX + nextX < maze.length && currentY + nextY >= 0 && currentY + nextY < maze[0].length && maze[currentX + nextX][currentY + nextY] != 1) {
                currentX += nextX;
                currentY += nextY;
            }
            
            if(!visited.contains(new Point(currentX, currentY))) {
                if(canVisit != true) {
                    canReach = canReach || dfs(maze, currentX, currentY, endX, endY, visited);
                }
                
            }
            
        }
        if(canReach == true){
            canVisit = true;
        }
        
        return canReach;
    }
    
}