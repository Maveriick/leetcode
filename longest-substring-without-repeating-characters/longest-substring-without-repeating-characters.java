class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int startingWindow = 0;
        int endingWindow = 0;
        Set<Character> existing = new HashSet<>();
        int currentSize = 0;
        while(endingWindow < s.length() && startingWindow < s.length()) {
            Character current = s.charAt(endingWindow);
            if(!existing.contains(current)){
                existing.add(current);
                currentSize++;
                longest  = Math.max(longest, currentSize);
                endingWindow ++;
            } else {
                while(s.charAt(startingWindow) != current){
                    existing.remove(s.charAt(startingWindow));
                    startingWindow++;
                    currentSize--;
                }
                
                existing.remove(s.charAt(startingWindow));
                startingWindow++; 
                currentSize--;
            }
        }
        return longest;
    }
}
