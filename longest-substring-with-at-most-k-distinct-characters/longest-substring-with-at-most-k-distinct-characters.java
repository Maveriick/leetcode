class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
         if(s.length() == 0 || k == 0) {
            return  0;
        }
        Set<Character> current = new HashSet<>();
        int endingWindow = 0;
        int startingWindow = 0;
        int maxOnes = 0;
        while(startingWindow < s.length() && endingWindow < s.length()) {
            Character currentCharacter = s.charAt(endingWindow);
            if(current.contains(currentCharacter)) {
                current.add(currentCharacter);
                endingWindow++;
                maxOnes = Math.max(endingWindow - startingWindow, maxOnes);
            } else {
                if(current.size() < k){
                    current.add(currentCharacter);
                    endingWindow++;
                    maxOnes = Math.max(endingWindow - startingWindow, maxOnes);
                } else {
                    while(current.size() >= k){
                        Character c = s.charAt(startingWindow);
                        current.remove(c);
                        startingWindow++;
                    }
                    
                    for(int j = startingWindow; j < endingWindow; j++){
                        if(!current.contains(s.charAt(j))){
                            current.add(s.charAt(j));
                        }
                    }
                }
            }
        }
        
        return maxOnes;
    }
}