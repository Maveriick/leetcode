class Point{
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int hashCode() {
        return 7 * this.x * 11 * this.y;
    }
    
    @Override
    public boolean equals(Object other) {
        Point o = (Point) other;
        return o.x == this.x && o.y == this.y;
    }
}

class Solution {
    int[] xDirs = new int[]{-1,1,0,0};
    int[] yDirs = new int[]{0,0,-1,1};
    boolean landExists = false;
    int maxDistance = 0;
    public int maxDistance(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    Point currentP = new Point(i, j);
                    maxDistance = Math.max(maxDistance,bfs(grid, currentP, grid.length, grid[0].length));
                }
            }
        }
        return landExists == true ? maxDistance : -1;
    }

    private int bfs(int[][] matrix, Point currentP, int rows, int cols) {
        Queue<Point> bfsQ = new LinkedList<>();
        Set<Point> visited = new HashSet<>();
        visited.add(currentP);
        bfsQ.add(currentP);
        int currentDistance = 0;
        while(!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            for(int i = 0; i < size; i++) {
                Point removed = bfsQ.remove();
                int currentX = removed.x;
                int currentY = removed.y;
                if(matrix[currentX][currentY] == 1) {
                    landExists = true;
                    return currentDistance;
                }
                for(int j = 0; j < 4; j++) {
                    int newX = currentX + xDirs[j];
                    int newY = currentY + yDirs[j];
                    Point possible = new Point(newX, newY);
                    if(newX >= 0 && newX < rows && newY >=0 && newY < cols) {
                        if(!visited.contains(possible)) {
                            visited.add(possible);
                            bfsQ.add(possible);
                        }
                    }
                }
            }
            currentDistance++;
        }
        return currentDistance;
    }
}