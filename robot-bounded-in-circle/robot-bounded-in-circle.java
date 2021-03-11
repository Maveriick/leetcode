

class Solution {

    public boolean isRobotBounded(String instructions) {
        int currentDirection = 0;
        int currentX = 0;
        int currentY = 0;
        for(int i = 0; i < instructions.length(); i++) {
            Character current = instructions.charAt(i);
            if(current == 'L') {
                currentDirection = (currentDirection + 3) % 4;
            } else if(current == 'R') {
                currentDirection = (currentDirection + 1) % 4;
            } else {
                if(currentDirection == 0) {
                    currentX++;
                } else if(currentDirection == 2) {
                    currentX--;
                } else if(currentDirection == 1) {
                    currentY ++;
                } else {
                    currentY --;
                }
            }
        }
        
       
        return (currentX == 0 && currentY == 0) || (currentDirection != 0) ;
        
    }
    
}

