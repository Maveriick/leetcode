class Solution {
    public boolean checkValidString(String s) {
        int leftParans = 0;
        int stars = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') leftParans++;
            else if(c == ')') {
                if(leftParans > 0) leftParans--;
                else if(stars > 0) stars--;
                else return false;
            } else {
                stars++;
                if(leftParans > 0) {
                    leftParans--;
                    stars++;
                }
            }
        }
        return leftParans == 0;
        
    }
}