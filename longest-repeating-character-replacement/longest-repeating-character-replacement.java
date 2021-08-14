class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> fMap = new HashMap<>();
        int startWindow = 0;
        int endWindow = 0;
        int maxLength = Integer.MIN_VALUE;
        while(endWindow < s.length()){
            Character currentChar = s.charAt(endWindow);
            int currentF = fMap.getOrDefault(currentChar, 0);
            fMap.put(currentChar, currentF + 1);
            
            int maxF = findMaxF(fMap);
            
            while((endWindow - startWindow + 1) - maxF > k) {
                int startWindowF = fMap.get(s.charAt(startWindow));
                fMap.put(s.charAt(startWindow), startWindowF - 1);
                startWindow ++;
            }
            
            maxLength = Math.max(maxLength, endWindow - startWindow + 1);
            endWindow++;
            
        }
        return maxLength;
    }
    
    
    private int findMaxF(Map<Character, Integer> fMap){
        int maxF = 0;
        for(Map.Entry<Character, Integer> entry: fMap.entrySet()){
            maxF = Math.max(maxF, entry.getValue());
        }
        return maxF;
    }
}