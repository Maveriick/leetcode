class Solution {
    public int countBinarySubstrings(String s) {
        int currentIndex = 1;
        int previousCount = 0;
        int currentCount = 1;
        int count = 0;
        
        while(currentIndex < s.length()) {
            if(s.charAt(currentIndex) != s.charAt(currentIndex - 1)) {
                
                count += Math.min(currentCount, previousCount);
                previousCount = currentCount;
                currentCount = 1;
            } else {
                currentCount ++;
            }
            currentIndex ++;
        }
        
        count += Math.min(previousCount, currentCount);  
        return count;
    }
  
}