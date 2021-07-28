class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pMap = buildMap(p);
        int startingWindow = 0;
        int endingWindow = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        List<Integer> solution = new ArrayList<>();
        while(endingWindow < s.length()) {
            Character current = s.charAt(endingWindow);
            int currentF = sMap.getOrDefault(current, 0);
            sMap.put(current, ++currentF);
            if(compare(pMap, sMap) == true){
                solution.add(startingWindow) ;
            }
            
            if(endingWindow - startingWindow + 1 < p.length()){
                endingWindow++;
            } else {
                endingWindow++;
                int currentFreq = sMap.getOrDefault(s.charAt(startingWindow), 0);
                currentFreq--;
                if(currentFreq == 0) {
                    sMap.remove(s.charAt(startingWindow));
                } else {
                     sMap.put(s.charAt(startingWindow), currentFreq);
                }
                startingWindow++;
            }
        }
        return solution;
    }
    
    
    private Map<Character, Integer> buildMap(String s) {
        Map<Character, Integer> fMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            int current = fMap.getOrDefault(s.charAt(i), 0);
            fMap.put(s.charAt(i), ++ current);
        }
        return fMap;
    }
    
    private boolean compare(Map<Character, Integer> pM, Map<Character, Integer> sM) {
       
        for(Map.Entry<Character, Integer> entry : pM.entrySet()) {
            Character key = entry.getKey();
            int value = entry.getValue();
            if(!sM.containsKey(key)) {
               
                return false;
            } else {
                if(!sM.get(key).equals(value)){
            
                    return false;
                } 
            }
        }
       
        return true;
      
    }
}