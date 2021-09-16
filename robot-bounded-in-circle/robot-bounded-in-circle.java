class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] dirs = new int[]{0,1,2,3};
        int currentDir = 0;
        int x = 0;
        int y = 0;
        for(int i = 0; i < instructions.length(); i++) {
            Character current = instructions.charAt(i);
            if(current == 'G'){
                if(currentDir == 0){
                    x++;
                } else if(currentDir == 1){
                    y ++;
                } else if(currentDir == 2){
                    x--;
                } else {
                    y--;
                }
            } else if(current == 'L'){
                currentDir = (currentDir + 3) % 4;
            } else {
                currentDir = (currentDir + 1) % 4;
            }
        }
        
        return (x == 0 && y == 0) ||(currentDir != 0);
    }
}