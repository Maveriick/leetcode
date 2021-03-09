class Point{
    public int x;
    public int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object other) {
        Point o = (Point) other;
        return this.x == o.x && this.y == o.y;
    }
    
    @Override
    public int hashCode() {
        return this.x * 13 * this.y * 19;
    }
}

class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        int[] xDirs = new int[]{2,1,-1,-2,-2,-1,1,2};
        int[] yDirs = new int[]{1,2,2,1,-1,-2,-2,-1};
        
        //{{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
        
        Queue<Point> bfsQ = new LinkedList<>();
        Point start = new Point(0,0);
        bfsQ.add(start);
        Set<Point> visited = new HashSet<>();
        visited.add(start);
        int steps = 0;
        while(!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            for(int i = 0; i < size; i++) {
                Point current = bfsQ.remove();
                if(current.x == x && current.y == y) {
                    return steps;
                }
                for(int j = 0; j < 8; j++) {
                    int newX = current.x + xDirs[j];
                    int newY = current.y + yDirs[j];
                    Point possible = new Point(newX, newY);
                    if(!visited.contains(possible) && newX >= -1 && newY >= -1){
                        visited.add(possible);
                        bfsQ.add(possible);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}