class Solution {
    public boolean validPalindrome(String s) {
       return isValid(s, 0, s.length() - 1, 0, 1);
    }
    
    private boolean isValid(String s, int start , int end, int changed, int allowed) {
        if(start >= end){
            return true;
        }
        
        if(s.charAt(start) == s.charAt(end)){
            return isValid(s, start+1, end-1, changed, allowed);
        } else {
            if(changed >= allowed){
                return false;
            } else {
                return isValid(s, start, end-1, changed+1, allowed) || isValid(s, start+1, end, changed+1, allowed);
            }
        }
    }
}

