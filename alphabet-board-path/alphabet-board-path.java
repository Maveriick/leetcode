class Point {
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
}

class Solution {
    public String alphabetBoardPath(String target) {
        String[] board = new String[]{"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        Map<Character, Point> positionMap = new HashMap<>();
        for(int i = 0; i < board.length; i++) {
            String currentWord = board[i];
            for(int j = 0; j < currentWord.length(); j++) {
                Character current = currentWord.charAt(j);
                Point p = new Point(i, j);
                positionMap.put(current, p);
            }
        }
        
        Point previousPos = new Point(0,0);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < target.length(); i++) {
            Character to = target.charAt(i);
            Point toPos = positionMap.get(to);
            int up = 0;
            int down = 0;
            int left = 0;
            int right = 0;
            
            // Calculate Up
            if(toPos.x < previousPos.x) {
                up = previousPos.x - toPos.x;
            }
            
            
            // Calculate Left
            if(toPos.y < previousPos.y) {
                left = previousPos.y - toPos.y;
            }
            
            
            // Calculate Right
            if(toPos.y > previousPos.y){
                right = toPos.y - previousPos.y;
            }
            
            
            // Calculate Down
            if(toPos.x > previousPos.x) {
                down = toPos.x - previousPos.x;
            }
           
            
            
            previousPos = toPos;
            
            if(up > 0) {
                for(int j = 0; j < up; j++) {
                    sb.append("U");
                }
            }
            
            if(left > 0) {
                for(int j = 0; j < left; j++) {
                    sb.append("L");
                }
            }
            
            if(right > 0) {
                for(int j = 0; j < right; j++) {
                    sb.append("R");
                }
            }
            
            
            if(down > 0) {
                for(int j = 0; j < down; j++) {
                    sb.append("D");
                }
            }
            
            sb.append("!");  
        }
        
        return sb.toString();
    }
}