class Point {
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int hashCode () {
        return 7 * this.x + 13 * this.y + 83;
    }
    
    @Override
    public boolean equals(Object other) {
        Point o = (Point) other;
        return this.x == o.x && this.y == o.y;
    }
}

class Solution {
    
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        List<Point> queensList = new ArrayList<>();
        for(int i = 0; i < queens.length; i++) {
            Point q = new Point(queens[i][0], queens[i][1]);
            queensList.add(q);
        }
        
        int kingX = king[0];
        int kingY = king[1];
        
        
        int startX = kingX;
        int startY = kingY;
        List<List<Integer>> sol = new ArrayList<>();
        
        // Up
        while(startY >= 0) {
            Point cQ = new Point(startX, startY);
            if(queensList.contains(cQ)) {
                List<Integer> partial = new ArrayList<>();
                partial.add(cQ.x);
                partial.add(cQ.y);
                sol.add(partial);
                break;
            }
            startY --;
        }
        
        
        // Down
        startX = kingX;
        startY = kingY;
        while(startY < 8) {
            Point cQ = new Point(startX, startY);
            if(queensList.contains(cQ)) {
                List<Integer> partial = new ArrayList<>();
                partial.add(cQ.x);
                partial.add(cQ.y);
                sol.add(partial);
                break;
            }
            startY ++;
        }
        
        
        
        
        // LEft
        startX = kingX;
        startY = kingY;
        while(startX >= 0) {
            Point cQ = new Point(startX, startY);
            if(queensList.contains(cQ)) {
                List<Integer> partial = new ArrayList<>();
                partial.add(cQ.x);
                partial.add(cQ.y);
                sol.add(partial);
                break;
            }
            startX --;
        }
        
        
        // RIght
        startX = kingX;
        startY = kingY;
        while(startX < 8) {
            Point cQ = new Point(startX, startY);
            if(queensList.contains(cQ)) {
                List<Integer> partial = new ArrayList<>();
                partial.add(cQ.x);
                partial.add(cQ.y);
                sol.add(partial);
                break;
            }
            startX ++;
        }
        
        
        
        // Up left
        startX = kingX;
        startY = kingY;
        while(startX >= 0 && startY >= 0) {
            Point cQ = new Point(startX, startY);
            if(queensList.contains(cQ)) {
                List<Integer> partial = new ArrayList<>();
                partial.add(cQ.x);
                partial.add(cQ.y);
                sol.add(partial);
                break;
            }
            startX --;
            startY --;
        }
        
        
        // Up right
        startX = kingX;
        startY = kingY;
        while(startX < 8 && startY >= 0) {
            Point cQ = new Point(startX, startY);
            if(queensList.contains(cQ)) {
                List<Integer> partial = new ArrayList<>();
                partial.add(cQ.x);
                partial.add(cQ.y);
                sol.add(partial);
                break;
            }
            startX ++;
            startY --;
        }
        
        
        // Down left
        startX = kingX;
        startY = kingY;
        while(startX >= 0 && startY < 8) {
            Point cQ = new Point(startX, startY);
            if(queensList.contains(cQ)) {
                List<Integer> partial = new ArrayList<>();
                partial.add(cQ.x);
                partial.add(cQ.y);
                sol.add(partial);
                break;
            }
            startX --;
            startY ++;
        }
        
        
        
        // Down right
        startX = kingX;
        startY = kingY;
        while(startX < 8 && startY < 8) {
            Point cQ = new Point(startX, startY);
            if(queensList.contains(cQ)) {
               List<Integer> partial = new ArrayList<>();
                partial.add(cQ.x);
                partial.add(cQ.y);
                sol.add(partial);
                break;
            }
            startX ++;
            startY ++;
        }
        
        return sol;
        
    }
}