class Point implements Comparable<Point>{
    public int x;
    public int y;
    public double distance;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = calculate();
    }
    
    private double calculate() {
        return Math.sqrt((x * x) + (y * y));
    }
    
    public double getDistance() {
        return this.distance;
    } 
    
    @Override
    public int compareTo(Point other){
        if(this.distance > other.getDistance()){
            return 1;
        } else if(this.distance < other.getDistance()){
            return -1;
        } else {
            return 0;
        }
        
    }
    
    
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>((a,b) -> b.compareTo(a));
        int minPoints = Math.min(k, points.length);
        int pointsAdded = 0;
        for(int i = 0; i < minPoints; i++) {
            int[] p = points[i];
            int x = p[0];
            int y = p[1];
            Point cP = new Point(x, y);
            maxHeap.add(cP);
            pointsAdded++;
        }
        
        for(int j = pointsAdded; j < points.length; j++) {
            int[] p = points[j];
            int x = p[0];
            int y = p[1];
            Point cP = new Point(x, y);
            if(cP.getDistance() < maxHeap.peek().getDistance()){
                maxHeap.remove();
                maxHeap.add(cP);
            }
        }
        
        int[][] sol = new int[k][2];
        for(int i = 0; i < k; i++){
            Point next = maxHeap.poll();
            sol[i][0] = next.x;
            sol[i][1] = next.y;
        }
        return sol;
    }
}