class Point implements Comparable<Point>{
    int value;
    int currentRow;
    int currentCol;
    
    public Point(int value, int currentRow, int currentCol) {
        this.value = value;
        this.currentRow = currentRow;
        this.currentCol = currentCol;
    }
    
    @Override
    public int compareTo(Point other){
        return this.value - other.value;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
       
        int rows = matrix.length;
        int cols = matrix[0].length;
        PriorityQueue<Point> pq = new PriorityQueue<>(Math.min(rows, k));
        

        for(int i = 0; i < Math.min(rows, k); i++){
            Point p = new Point(matrix[i][0], i, 0);
            pq.add(p);
           
        }
    
        Point element = pq.peek();
        while(k-- > 0) {
            element = pq.poll();
            int row = element.currentRow;
            int col = element.currentCol;
            if(col < cols - 1){
                pq.add(new Point(matrix[row][col + 1], row, col + 1));
            }
           
            
        }
        
        return element.value;
        
        
       
    }
}