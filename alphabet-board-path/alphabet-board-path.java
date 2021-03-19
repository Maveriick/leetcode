class Point{
    public int x;
    public int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int hashCode() {
        return 7 * this.x * 13 * this.y;
    }
    
    @Override
    public boolean equals(Object other){
        Point p = (Point) other;
        return p.x == this.x && p.y == this.y;
    }
    
    @Override
    public String toString() {
        return "x:" + x + ",y" + y;
    }
}
class Solution {
    public String alphabetBoardPath(String target) {
        Map<Character, Point> position = new HashMap<>();
        String[] board = new String[]{"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        for(int i = 0; i < board.length; i++){
            String word = board[i];
            for(int j = 0; j < word.length(); j++) {
                Point p = new Point(i, j);
                position.put(word.charAt(j), p);
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        Character previous = 'a';
        for(int i = 0; i < target.length(); i++) {
           
            Point previousPoint = position.get(previous);
            
            Character current = target.charAt(i);
            Point currentPoint = position.get(current);
            
            /*
            System.out.println(previous);
            System.out.println(current);
            */
            
            int xDiff = Math.abs(previousPoint.x - currentPoint.x);
            int yDiff = Math.abs(previousPoint.y - currentPoint.y);
            
            System.out.println();
            
            if(xDiff == 0 && yDiff == 0) {
                sb.append("!");
                previous = current;
            } else {
                
                int down = currentPoint.x - previousPoint.x > 0 ? Math.abs(currentPoint.x - previousPoint.x) : 0;
                int up = currentPoint.x - previousPoint.x < 0 ? Math.abs(currentPoint.x - previousPoint.x) : 0;
                int left = currentPoint.y - previousPoint.y < 0 ? Math.abs(currentPoint.y - previousPoint.y) : 0;
                int right = currentPoint.y - previousPoint.y > 0 ? Math.abs(currentPoint.y - previousPoint.y) : 0;
                
                for(int j = 0; j < up; j++){
                    sb.append("U");
                }
                
                for(int j = 0; j < right; j++){
                    sb.append("R");
                }
                
                for(int j = 0; j < left; j++){
                    sb.append("L");
                }
                
                for(int j = 0; j < down; j++){
                    sb.append("D");
                }
                
                sb.append("!");
                previous = current;
                
            }
        }
        return sb.toString();
        
    }
}